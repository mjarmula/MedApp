package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
