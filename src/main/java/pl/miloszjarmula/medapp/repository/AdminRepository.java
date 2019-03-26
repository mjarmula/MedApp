package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
