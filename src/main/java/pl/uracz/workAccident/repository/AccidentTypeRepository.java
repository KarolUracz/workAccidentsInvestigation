package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AccidentType;

@Repository
public interface AccidentTypeRepository extends JpaRepository<AccidentType, Long> {
}
