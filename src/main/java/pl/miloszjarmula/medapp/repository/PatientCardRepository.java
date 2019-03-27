package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.PatientCard;

public interface PatientCardRepository extends JpaRepository<PatientCard, Long > {
}
