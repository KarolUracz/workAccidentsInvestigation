package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AccidentCause;

@Repository
public interface AccidentCauseRepository extends JpaRepository<AccidentCause, Long> {
}
