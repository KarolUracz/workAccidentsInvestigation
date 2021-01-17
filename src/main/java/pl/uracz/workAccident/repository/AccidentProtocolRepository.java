package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AccidentProtocol;

@Repository
public interface AccidentProtocolRepository extends JpaRepository<AccidentProtocol, Long> {
}
