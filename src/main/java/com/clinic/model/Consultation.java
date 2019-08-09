package com.clinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultation")
@Data
@NoArgsConstructor
public class Consultation {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "consultation_id_seq", sequenceName = "consultation_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consultation_id_seq")
	Long id;

	@Column(name = "happened_on")
	LocalDateTime happenedOn;

	@ManyToOne
	@JoinColumn(name = "fk_patient_id")
	Patient patient;

	@ManyToOne
	@JoinColumn(name = "fk_physician_id")
	Physician physician;
}