package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import pl.uracz.workAccident.dto.AccidentInvestigatorDto;
import pl.uracz.workAccident.entity.AccidentInvestigator;

@Mapper(componentModel = "spring")
public interface AccidentInvestigatorMapper {

    AccidentInvestigator accidentInvestigatorFromDto(AccidentInvestigatorDto accidentInvestigatorDto);
    AccidentInvestigatorDto dtoFromAccidentInvestigator(AccidentInvestigator accidentInvestigator);
}
