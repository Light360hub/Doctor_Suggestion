package com.DocSuggest.DocSuggest.Controller;

import com.DocSuggest.DocSuggest.Entity.Doctor;
import com.DocSuggest.DocSuggest.Services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService service;
    public DoctorController(DoctorService service) { this.service = service; }

    @PostMapping
    public Doctor addDoctor(@Valid @RequestBody Doctor doctor) {
        return service.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        service.delete(id);
    }
}
