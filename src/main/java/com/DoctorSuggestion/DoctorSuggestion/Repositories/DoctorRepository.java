package com.DocSuggest.DocSuggest.Repositories;


import com.DocSuggest.DocSuggest.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, Doctor.Speciality speciality);
}
