package pl.miloszjarmula.medapp.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

public class LocalDateTimeConverter implements Converter<String, LocalDateTime>{

    @Override
    public LocalDateTime convert(String s) {
        if(s == null || s.isEmpty()){
            return  null;
        }
        return LocalDateTime.parse(s);
    }
}