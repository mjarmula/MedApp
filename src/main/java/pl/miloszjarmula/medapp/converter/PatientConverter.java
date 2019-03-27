package pl.miloszjarmula.medapp.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.miloszjarmula.medapp.entity.Patient;
import pl.miloszjarmula.medapp.repository.PatientRepository;

public class PatientConverter implements Converter<String, Patient> {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient convert(String s) {
        return patientRepository.getOne(Long.parseLong(s)) ;
    }
}
