package pl.miloszjarmula.medapp.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.miloszjarmula.medapp.entity.Doctor;
import pl.miloszjarmula.medapp.repository.DoctorRepository;

import java.util.Optional;

public class DoctorConvert implements Converter<String, Doctor> {

    @Autowired
    DoctorRepository doctorRepository;



    @Override
    public Doctor convert(String s) {
        // return doctorRepository.findById(Long.parseLong(s)); tak mi nie dziala dostaje komunitakt ze to powinno zwracac Optional<Docotor>
        return doctorRepository.getOne(Long.parseLong(s));
    }
}
