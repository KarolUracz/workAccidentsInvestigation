package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AccidentRegister;

@Repository
public interface AccidentRegisterRepository extends JpaRepository<AccidentRegister, Long> {
    boolean existsByProtocolNumber(String protocolNumber);
    AccidentRegister findByProtocolNumber (String protocolNumber);
}
