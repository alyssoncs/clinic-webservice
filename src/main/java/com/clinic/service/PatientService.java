package com.clinic.service;

import com.clinic.model.Patient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PatientService {
	public Patient validDateOfBirth(Patient patient) {
		LocalDate currentDate = LocalDate.now();
		LocalDate patientDateOfBirth  = patient.getDateOfBirth();

		if (patientDateOfBirth != null) {
			if (patientDateOfBirth.isAfter(currentDate)) {
				patientDateOfBirth = currentDate;
			}
		} else {
			patientDateOfBirth = currentDate;
		}

		Patient validPatient = new Patient();
		BeanUtils.copyProperties(patient, validPatient);
		validPatient.setDateOfBirth(patientDateOfBirth);

		return validPatient;
	}
}
