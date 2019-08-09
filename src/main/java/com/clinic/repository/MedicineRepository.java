package com.clinic.repository;

import com.clinic.model.Medicine;
import org.springframework.data.repository.CrudRepository;

public interface MedicineRepository extends CrudRepository<Medicine, Long> {
}
