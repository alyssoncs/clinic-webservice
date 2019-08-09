package com.clinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "prescription")
@Data
@NoArgsConstructor
public class Prescription {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "prescription_id_seq", sequenceName = "prescription_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_id_seq")
	Long id;

	@OneToOne
	@JoinColumn(name = "fk_consultation_id")
	Consultation consultation;

	@OneToMany(mappedBy = "prescription")
	List<PrescriptionMedicine> medicines;

	/*@OneToOne
	@MapsId
	@JoinColumns({
			@JoinColumn(name = "fk_patient", referencedColumnName = "fk_patient"),
			@JoinColumn(name = "fk_physician", referencedColumnName = "fk_physician"),
			@JoinColumn(name = "fk_happened_on", referencedColumnName = "happened_on")
	})
	Consultation consultation;*/
}
