package com.clinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "physician")
public class Physician {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "physician_id_seq", sequenceName = "physician_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "physician_id_seq")
	Long id;

	@Column(name = "name")
	String name;

	@OneToMany(mappedBy = "physician")
	List<Consultation> consultations;
}
