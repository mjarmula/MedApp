package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Doctor;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findAllByFirstNameContainingAndLastNameContainingAndSepcializationContaining(String firstName, String lastName, String specialziation);
}
