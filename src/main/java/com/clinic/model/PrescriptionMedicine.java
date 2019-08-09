package com.clinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "prescription_medicine")
@Data
@NoArgsConstructor
public class PrescriptionMedicine {
	@EmbeddedId
	PrescriptionMedicinePK id;

	@Column(name = "quantity")
	Long quantity;

	@Column(name = "frequency_in_hours")
	Long frequencyInHours;

	@ManyToOne
	@MapsId("prescriptionId")
	@JoinColumn(name = "fk_prescription_id")
	Prescription prescription;

	@ManyToOne
	@MapsId("medicineId")
	@JoinColumn(name = "fk_medicine_id")
	Medicine medicine;
}
