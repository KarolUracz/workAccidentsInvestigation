package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import pl.uracz.workAccident.dto.AccidentTypeDto;
import pl.uracz.workAccident.entity.AccidentType;

@Mapper(componentModel = "spring")
public interface AccidentTypeMapper {

    AccidentType accidentTypeFromDto(AccidentTypeDto accidentTypeDto);
    AccidentTypeDto dtoFromAccidentType(AccidentType accidentType);
}
