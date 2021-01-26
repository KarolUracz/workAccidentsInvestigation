package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AccidentProtocol;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AccidentProtocolRepository extends JpaRepository<AccidentProtocol, Long> {

    @Query(value = "select count (AccidentProtocol) from AccidentProtocol ap where ap.isAccidentAtWork = true and ap.finishedProtocol = true")
    Integer numberOfAccidents();
    @Query("select ap from AccidentProtocol ap where ap.finishedProtocol = false")
    List<AccidentProtocol> findAllUnfinished();
    AccidentProtocol findByProtocolNumber(String protocolNumber);
    @Transactional
    int deleteAccidentProtocolByProtocolNumber(String protocolNumber);

}
