package com.clinic.controller;

import com.clinic.event.ResourceCreatedEvent;
import com.clinic.model.Patient;
import com.clinic.repository.PatientRepository;
import com.clinic.service.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	PatientRepository patientRepository;

	@Autowired
	PatientService patientService;

	@Autowired
	ApplicationEventPublisher publisher;

	@GetMapping
	public ResponseEntity<Iterable<Patient>> getAll() {
		Iterable<Patient> patients = patientRepository.findAll();
		return ResponseEntity.ok(patients);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patient> getById(@PathVariable Long id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isPresent()) {
			return ResponseEntity.ok(patient.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Patient> create(@RequestBody Patient patient, HttpServletResponse response) {
		patient = patientService.validDateOfBirth(patient);
		Patient savedPatient = patientRepository.save(patient);

		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedPatient.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
	}

	@PutMapping("/{id}")
	public  ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient patient) {
		patient = patientService.validDateOfBirth(patient);

		Optional<Patient> savedPatient = patientRepository.findById(id);
		if (savedPatient.isPresent()) {
			BeanUtils.copyProperties(patient, savedPatient.get(), "id");
			patientRepository.save(savedPatient.get());

			return ResponseEntity.ok(savedPatient.get());
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isPresent()) {
			patientRepository.delete(patient.get());
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
}
