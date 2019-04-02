package pl.miloszjarmula.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miloszjarmula.medapp.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
