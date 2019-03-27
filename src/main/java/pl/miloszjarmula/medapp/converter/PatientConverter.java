package pl.miloszjarmula.medapp.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.miloszjarmula.medapp.entity.Patient;
import pl.miloszjarmula.medapp.repository.PatientRepository;

import java.util.Optional;

public class PatientConverter implements Converter<String, Optional<Patient>> {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Optional<Patient> convert(String s) {
        Optional<Patient> byId = patientRepository.findById(Long.parseLong(s));
        return  byId;
    }
}
