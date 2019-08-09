package com.clinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "unity")
@Data
@NoArgsConstructor
public class Unity {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "unity_id_seq", sequenceName = "unity_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unity_id_seq")
	Long id;

	@Column(name = "name", unique = true)
	String name;
}
