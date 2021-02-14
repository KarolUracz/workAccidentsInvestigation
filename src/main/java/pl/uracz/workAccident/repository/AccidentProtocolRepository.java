package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AccidentProtocol;
import pl.uracz.workAccident.entity.Company;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AccidentProtocolRepository extends JpaRepository<AccidentProtocol, Long> {

    @Query(value = "select count(*) from accident_protocol where finished_protocol = true and is_accident_at_work = true", nativeQuery = true)
    Integer numberOfAccidents();
    @Query("select ap from AccidentProtocol ap where ap.finishedProtocol = false")
    List<AccidentProtocol> findAllUnfinished();
    AccidentProtocol findByProtocolNumber(String protocolNumber);
    @Transactional
    int deleteAccidentProtocolByProtocolNumber(String protocolNumber);
    boolean existsAccidentProtocolByProtocolNumber (String protocolNumber);
    boolean existsAccidentProtocolByProtocolNumberAndCompany(String protocolNumber, Company company);

}
