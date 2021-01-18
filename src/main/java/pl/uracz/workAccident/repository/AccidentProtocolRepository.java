package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AccidentProtocol;

@Repository
public interface AccidentProtocolRepository extends JpaRepository<AccidentProtocol, Long> {

    @Query(value = "select count (AccidentProtocol) from AccidentProtocol ap where ap.isAccidentAtWork = true and ap.finishedProtocol = true")
    Integer numberOfAccidents();

}
