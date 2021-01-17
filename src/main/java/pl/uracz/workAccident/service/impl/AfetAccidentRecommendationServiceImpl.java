package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.AfterAccidentRecommendation;
import pl.uracz.workAccident.repository.AfterAccidentRecommendationRepository;
import pl.uracz.workAccident.service.AfterAccidentRecommendationService;

import java.util.List;

@Service
public class AfetAccidentRecommendationServiceImpl implements AfterAccidentRecommendationService {

    private AfterAccidentRecommendationRepository afterAccidentRecommendationRepository;

    public AfetAccidentRecommendationServiceImpl(AfterAccidentRecommendationRepository afterAccidentRecommendationRepository) {
        this.afterAccidentRecommendationRepository = afterAccidentRecommendationRepository;
    }

    @Override
    public List<AfterAccidentRecommendation> findAll() {
        return afterAccidentRecommendationRepository.findAll();
    }

    @Override
    public void saveAfterAccidentRecommendation(AfterAccidentRecommendation afterAccidentRecommendation) {
        afterAccidentRecommendationRepository.save(afterAccidentRecommendation);
    }

    @Override
    public AfterAccidentRecommendation readAfterAccidentRecommendation(long id) {
        return afterAccidentRecommendationRepository.getOne(id);
    }

    @Override
    public void deleteAfterAccidentRecommendation(long id) {
        afterAccidentRecommendationRepository.deleteById(id);
    }
}
