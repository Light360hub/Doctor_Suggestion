package com.DocSuggest.DocSuggest.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3)
    private String name;

    @Size(max = 20)
    private String city;

    @Email
    private String email;

    @Size(min = 10)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    public enum Speciality {
        ORTHOPAEDIC, GYNECOLOGY, DERMATOLOGY, ENT
    }
}
