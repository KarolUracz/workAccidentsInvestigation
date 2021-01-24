package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.AccidentInvestigatorDto;
import pl.uracz.workAccident.entity.AccidentInvestigator;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AccidentInvestigatorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", source = "companyDto")
    AccidentInvestigator accidentInvestigatorFromDto(AccidentInvestigatorDto accidentInvestigatorDto);
    @Mapping(target = "companyDto", source = "company")
    AccidentInvestigatorDto dtoFromAccidentInvestigator(AccidentInvestigator accidentInvestigator);
    Set<AccidentInvestigatorDto> accidentInvestigatorToDto(Set<AccidentInvestigator> accidentInvestigators);
}
