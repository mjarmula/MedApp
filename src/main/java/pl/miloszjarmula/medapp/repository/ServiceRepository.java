package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Service;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findAllByNameContainingAndDescriptionContaining(String name, String  description);
}
