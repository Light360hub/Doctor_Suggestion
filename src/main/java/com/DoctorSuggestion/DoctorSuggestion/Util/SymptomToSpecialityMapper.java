package com.DocSuggest.DocSuggest.Util;

import com.DocSuggest.DocSuggest.Entity.Doctor;
import com.DocSuggest.DocSuggest.Entity.Patient;

import java.util.Map;

public class SymptomToSpecialityMapper {
    private static final Map<Patient.Symptom, Doctor.Speciality> map = Map.of(
            Patient.Symptom.ARTHRITIS, Doctor.Speciality.ORTHOPAEDIC,
            Patient.Symptom.BACK_PAIN, Doctor.Speciality.ORTHOPAEDIC,
            Patient.Symptom.TISSUE_INJURIES, Doctor.Speciality.ORTHOPAEDIC,
            Patient.Symptom.DYSMENORRHEA, Doctor.Speciality.GYNECOLOGY,
            Patient.Symptom.SKIN_INFECTION, Doctor.Speciality.DERMATOLOGY,
            Patient.Symptom.SKIN_BURN, Doctor.Speciality.DERMATOLOGY,
            Patient.Symptom.EAR_PAIN, Doctor.Speciality.ENT
    );

    public static Doctor.Speciality getSpeciality(Patient.Symptom symptom) {
        return map.get(symptom);
    }
}

