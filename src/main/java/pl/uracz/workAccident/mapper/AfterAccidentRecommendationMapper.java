package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.AfterAccidentRecommendationDto;
import pl.uracz.workAccident.entity.AfterAccidentRecommendation;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AfterAccidentRecommendationMapper {

    @Mapping(target = "id", ignore = true)
    AfterAccidentRecommendation accidentRecommendationFromDto (AfterAccidentRecommendationDto afterAccidentRecommendationDto);
    AfterAccidentRecommendationDto dtoFromAccidentRecommendation(AfterAccidentRecommendation afterAccidentRecommendation);
    Set<AfterAccidentRecommendationDto> recommendationToDto (Set<AfterAccidentRecommendation> afterAccidentRecommendations);
}
