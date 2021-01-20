package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import pl.uracz.workAccident.dto.AccidentEffectDto;
import pl.uracz.workAccident.entity.AccidentEffect;

@Mapper(componentModel = "spring")
public interface AccidentEffectMapper {

    AccidentEffect accidentEffectFromDto(AccidentEffectDto accidentEffectDto);
    AccidentEffectDto accidentEffectToDto(AccidentEffect accidentEffect);
}
