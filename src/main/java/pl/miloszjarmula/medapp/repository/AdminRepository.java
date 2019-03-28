package pl.miloszjarmula.medapp.repository;

import org.hibernate.property.access.internal.PropertyAccessStrategyNoopImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Admin;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findAllByFirstNameContainingAndLastNameContainingAndEmailContainingAndPeselContainingAndEmailContainingAndAdressContaining
            (String firstName, String lastName, String email, String pesel, String phoneNumber, String adress);


}
