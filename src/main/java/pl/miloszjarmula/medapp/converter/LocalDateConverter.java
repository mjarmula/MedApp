package pl.miloszjarmula.medapp.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class LocalDateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String s) {
        if(s == null || s.isEmpty()){
            return  null;
        }
        return LocalDate.parse(s);
    }
}
