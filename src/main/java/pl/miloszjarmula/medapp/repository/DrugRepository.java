package pl.miloszjarmula.medapp.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.miloszjarmula.medapp.entity.Drug;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long> {

}
