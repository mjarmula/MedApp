package pl.miloszjarmula.medapp.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.miloszjarmula.medapp.entity.Doctor;
import pl.miloszjarmula.medapp.repository.DoctorRepository;

import java.util.Optional;

public class DoctorConvert implements Converter<String, Optional<Doctor>> {

    @Autowired
    DoctorRepository doctorRepository;



    @Override
    public Optional<Doctor> convert(String s) {
        Optional<Doctor> byId = doctorRepository.findById(Long.parseLong(s));
        return byId;
    }
}
