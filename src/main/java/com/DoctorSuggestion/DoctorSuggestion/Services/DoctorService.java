package com.DocSuggest.DocSuggest.Services;

import com.DocSuggest.DocSuggest.Entity.Doctor;
import com.DocSuggest.DocSuggest.Repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository repo;
    public DoctorService(DoctorRepository repo) { this.repo = repo; }

    public Doctor save(Doctor doctor) { return repo.save(doctor); }

    public void delete(Long id) { repo.deleteById(id); }

    public List<Doctor> suggestDoctors(String city, Doctor.Speciality speciality) {
        return repo.findByCityAndSpeciality(city, speciality);
    }
}
