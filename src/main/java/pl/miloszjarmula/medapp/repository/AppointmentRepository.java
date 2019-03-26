package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
