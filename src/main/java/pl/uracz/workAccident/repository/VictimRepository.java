package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.Victim;

@Repository
public interface VictimRepository extends JpaRepository<Victim, Long> {
}
