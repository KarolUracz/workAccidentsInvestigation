package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import pl.uracz.workAccident.dto.AfterAccidentRecommendationDto;
import pl.uracz.workAccident.entity.AfterAccidentRecommendation;

@Mapper(componentModel = "spring")
public interface AfterAccidentRecommendationMapper {

    AfterAccidentRecommendation accidentRecommendationFromDto (AfterAccidentRecommendationDto afterAccidentRecommendationDto);
    AfterAccidentRecommendationDto dtoFromAccidentRecommendation(AfterAccidentRecommendation afterAccidentRecommendation);
}
