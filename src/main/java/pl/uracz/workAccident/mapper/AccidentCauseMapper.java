package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import pl.uracz.workAccident.dto.AccidentCauseDto;
import pl.uracz.workAccident.entity.AccidentCause;

@Mapper(componentModel = "spring")
public interface AccidentCauseMapper {

    AccidentCause accidentCauseFromDto(AccidentCauseDto accidentCauseDto);
    AccidentCauseDto accidentCauseToDto (AccidentCause accidentCause);
}
