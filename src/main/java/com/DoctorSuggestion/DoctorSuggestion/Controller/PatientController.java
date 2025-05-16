package com.DocSuggest.DocSuggest.Controller;

import com.DocSuggest.DocSuggest.Entity.Doctor;
import com.DocSuggest.DocSuggest.Entity.Patient;
import com.DocSuggest.DocSuggest.Services.DoctorService;
import com.DocSuggest.DocSuggest.Services.PatientService;
import com.DocSuggest.DocSuggest.Util.SymptomToSpecialityMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    private final DoctorService doctorService;

    public PatientController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @PostMapping
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.delete(id);
    }

    @GetMapping("/suggest-doctor/{id}")
    public Object suggestDoctor(@PathVariable Long id) {
        Patient patient = patientService.getById(id);
        if (patient == null) return "Patient not found";

        String city = patient.getCity();
        if (!city.equalsIgnoreCase("Delhi") && !city.equalsIgnoreCase("Noida") && !city.equalsIgnoreCase("Faridabad"))
            return "We are still waiting to expand to your location";

        Doctor.Speciality speciality = SymptomToSpecialityMapper.getSpeciality(patient.getSymptom());
        List<Doctor> suggested = doctorService.suggestDoctors(city, speciality);
        if (suggested.isEmpty())
            return "There isn’t any doctor present at your location for your symptom";

        return suggested;
    }
}
