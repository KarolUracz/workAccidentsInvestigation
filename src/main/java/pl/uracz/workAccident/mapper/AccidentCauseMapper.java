package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.AccidentCauseDto;
import pl.uracz.workAccident.entity.AccidentCause;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AccidentCauseMapper {

    @Mapping(target = "id", ignore = true)
    AccidentCause accidentCauseFromDto(AccidentCauseDto accidentCauseDto);
    AccidentCauseDto accidentCauseToDto (AccidentCause accidentCause);
    List<AccidentCauseDto> accidentCauseToDto (List<AccidentCause> accidentCauses);
}
