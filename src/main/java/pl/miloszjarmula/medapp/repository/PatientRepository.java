package pl.miloszjarmula.medapp.repository;

import org.hibernate.property.access.internal.PropertyAccessStrategyNoopImpl;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAllByFirstNameContainingAndLastNameContainingAndPeselContainingAndAdressContainingAndEmailContaining(String firstName, String lastName, String pesel, String adress, String email);
}
