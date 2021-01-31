package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.AccidentInvestigatorDto;
import pl.uracz.workAccident.entity.AccidentInvestigator;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AccidentInvestigatorMapper {

    @Mapping(target = "id", ignore = true)
    AccidentInvestigator accidentInvestigatorFromDto(AccidentInvestigatorDto accidentInvestigatorDto);
    AccidentInvestigatorDto dtoFromAccidentInvestigator(AccidentInvestigator accidentInvestigator);
    List<AccidentInvestigatorDto> accidentInvestigatorToDto(List<AccidentInvestigator> accidentInvestigators);
}
