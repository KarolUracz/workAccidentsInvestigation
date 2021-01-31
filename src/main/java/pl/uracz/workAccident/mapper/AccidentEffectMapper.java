package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.AccidentEffectDto;
import pl.uracz.workAccident.entity.AccidentEffect;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AccidentEffectMapper {

    @Mapping(target = "id", ignore = true)
    AccidentEffect accidentEffectFromDto(AccidentEffectDto accidentEffectDto);
    AccidentEffectDto accidentEffectToDto(AccidentEffect accidentEffect);
    List<AccidentEffectDto> accidentEffectToDto (List<AccidentEffect> accidentEffects);
}
