package com.clinic.repository;

import com.clinic.model.Consultation;
import org.springframework.data.repository.CrudRepository;

public interface ConsultationRepository extends CrudRepository<Consultation, Long> {
}
