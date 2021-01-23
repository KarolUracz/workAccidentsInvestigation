package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.AccidentProtocolDto;
import pl.uracz.workAccident.dto.UnfinishedProtocolDto;
import pl.uracz.workAccident.entity.AccidentProtocol;

@Mapper(componentModel = "spring")
public interface AccidentProtocolMapper {

    AccidentProtocol protocolFromDto (AccidentProtocolDto accidentProtocolDto);
    AccidentProtocolDto dtoFromAccidentProtocol(AccidentProtocol accidentProtocol);
}
