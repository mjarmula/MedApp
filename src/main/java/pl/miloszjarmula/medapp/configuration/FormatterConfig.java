package pl.miloszjarmula.medapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.miloszjarmula.medapp.converter.DoctorConvert;
import pl.miloszjarmula.medapp.converter.LocalDateConverter;
import pl.miloszjarmula.medapp.converter.LocalDateTimeConverter;
import pl.miloszjarmula.medapp.converter.PatientConverter;

@Configuration
public class FormatterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(localDateConverter());
        registry.addConverter(localDateTimeConverter());
        registry.addConverter(doctorConvert());
        registry.addConverter(patientConverter());
    }

    @Bean
    public LocalDateConverter localDateConverter(){
        return new LocalDateConverter();
    }

    @Bean
    public LocalDateTimeConverter localDateTimeConverter(){
        return new LocalDateTimeConverter();
    }

    @Bean
    public DoctorConvert doctorConvert(){
        return new DoctorConvert();
    }

    @Bean
    public PatientConverter patientConverter(){
        return new PatientConverter();
    }
}
