package com.clinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "medicine")
@Data
@NoArgsConstructor
public class Medicine {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "medicine_id_seq", sequenceName = "medicine_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicine_id_seq")
	Long id;

	@Column(name = "name")
	String name;

	@ManyToOne
	@JoinColumn(name = "fk_unity_id")
	Unity unity;
}
