package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
