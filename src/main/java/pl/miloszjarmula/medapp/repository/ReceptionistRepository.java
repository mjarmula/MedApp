package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.miloszjarmula.medapp.entity.Receptionist;

import java.util.List;


public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {

    List<Receptionist> findAllByFirstNameContainingAndLastNameContainingAndEmailContaining(String firstName, String lastName, String email);
}
