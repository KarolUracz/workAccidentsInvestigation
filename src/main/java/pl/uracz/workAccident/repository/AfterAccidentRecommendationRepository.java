package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.AfterAccidentRecommendation;

@Repository
public interface AfterAccidentRecommendationRepository extends JpaRepository<AfterAccidentRecommendation, Long> {
}
