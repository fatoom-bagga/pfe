package com.fatimetou.patient.repositories;

import com.fatimetou.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
