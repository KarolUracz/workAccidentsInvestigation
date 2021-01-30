package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AccidentRegister;
import pl.uracz.workAccident.entity.Company;

import java.util.List;

@Repository
public interface AccidentRegisterRepository extends JpaRepository<AccidentRegister, Long> {
    boolean existsByProtocolNumber(String protocolNumber);
    AccidentRegister findByProtocolNumber (String protocolNumber);
    List<AccidentRegister> findByCompany (Company company);
}
