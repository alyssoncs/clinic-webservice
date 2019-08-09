package com.clinic.model;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@EqualsAndHashCode
public class ConsultationPK implements Serializable {
	@Column(name = "fk_patient")
	Long patientId;

	@Column(name = "fk_physician")
	Long physicianId;

	@Column(name = "happened_on")
	LocalDateTime happenedOn;
}
