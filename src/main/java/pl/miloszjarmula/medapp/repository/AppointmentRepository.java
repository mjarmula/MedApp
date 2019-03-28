package pl.miloszjarmula.medapp.repository;

import org.hibernate.property.access.internal.PropertyAccessStrategyNoopImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Appointment;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByPatientLastNameContainingAndDoctorLastNameContainingAndAppointmentDateTime(String patient, String doctor, LocalDateTime appointmentDateTime);
}
