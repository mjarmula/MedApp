package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.PatientCard;

import java.util.List;

public interface PatientCardRepository extends JpaRepository<PatientCard, Long > {
        List<PatientCard> findAllByPatientFirstNameContainingAndPatientLastNameContaining(String firstName, String lastName);
}
