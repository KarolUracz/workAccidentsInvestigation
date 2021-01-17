package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AfterAccidentRecommendation;

import java.util.List;

public interface AfterAccidentRecommendationService {
    List<AfterAccidentRecommendation> findAll();
    boolean saveAfterAccidentRecommendation(AfterAccidentRecommendation afterAccidentRecommendation);
    AfterAccidentRecommendation readAfterAccidentRecommendation(long id);
    boolean updateAfterAccidentRecommendation(AfterAccidentRecommendation afterAccidentRecommendation);
    boolean deleteAfterAccidentRecommendation(long id);
}
