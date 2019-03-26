package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.miloszjarmula.medapp.entity.Receptionist;


public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {

}
