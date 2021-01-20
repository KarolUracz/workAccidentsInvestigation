package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.AfterAccidentRecommendationDto;
import pl.uracz.workAccident.entity.AfterAccidentRecommendation;

import java.util.List;

public interface AfterAccidentRecommendationService {
    List<AfterAccidentRecommendation> findAll();
    void saveAfterAccidentRecommendation(AfterAccidentRecommendation afterAccidentRecommendation);
    void saveAfterAccidentRecommendation(AfterAccidentRecommendationDto afterAccidentRecommendationDto);
    AfterAccidentRecommendation readAfterAccidentRecommendation(long id);
    void deleteAfterAccidentRecommendation(long id);
}
