package com.clinic.repository;

import com.clinic.model.Physician;
import org.springframework.data.repository.CrudRepository;

public interface PhysicianRepository extends CrudRepository<Physician, Long> {
}
