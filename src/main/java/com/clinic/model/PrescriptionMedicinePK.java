package com.clinic.model;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@EqualsAndHashCode
public class PrescriptionMedicinePK implements Serializable {

	@Column(name = "fk_medicine")
	Long prescriptionId;

	@Column(name = "fk_medicine")
	Long medicineId;
}
