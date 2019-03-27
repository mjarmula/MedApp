package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
