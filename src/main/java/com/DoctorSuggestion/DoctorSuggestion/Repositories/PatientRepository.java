package com.DocSuggest.DocSuggest.Repositories;

import com.DocSuggest.DocSuggest.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {}
