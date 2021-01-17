package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AccidentEffect;

@Repository
public interface AccidentEffectRepository extends JpaRepository<AccidentEffect, Long> {
}
