package com.DocSuggest.DocSuggest.Services;

import com.DocSuggest.DocSuggest.Entity.Patient;
import com.DocSuggest.DocSuggest.Repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository repo;
    public PatientService(PatientRepository repo) { this.repo = repo; }

    public Patient save(Patient patient) { return repo.save(patient); }

    public void delete(Long id) { repo.deleteById(id); }

    public Patient getById(Long id) { return repo.findById(id).orElse(null); }
}
