package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.AccidentTypeDto;
import pl.uracz.workAccident.entity.AccidentType;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AccidentTypeMapper {

    @Mapping(target = "id", ignore = true)
    AccidentType accidentTypeFromDto(AccidentTypeDto accidentTypeDto);
    AccidentTypeDto dtoFromAccidentType(AccidentType accidentType);
    Set<AccidentTypeDto> accidentTypeToDto(Set<AccidentType> accidentTypes);
}
