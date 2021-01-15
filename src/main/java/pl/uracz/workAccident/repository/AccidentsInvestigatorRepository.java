package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AccidentInvestigator;

@Repository
public interface AccidentsInvestigatorRepository extends JpaRepository<AccidentInvestigator, Long> {
}
