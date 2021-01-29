package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.AccidentRegisterDto;
import pl.uracz.workAccident.entity.AccidentProtocol;
import pl.uracz.workAccident.entity.AccidentRegister;

@Mapper(componentModel = "spring")
public interface AccidentRegisterMapper {

    AccidentRegister registerFromDto (AccidentRegisterDto accidentRegisterDto);
    AccidentRegisterDto registerToDto (AccidentRegister accidentRegister);

    @Mapping(target = "accidentPlace", ignore = true)
    @Mapping(target = "daysOfWorkAbsence", ignore = true)
    @Mapping(target = "dateOfDeliveryToZus", ignore = true)
    @Mapping(target = "victimFullName", expression = "java(accidentProtocol.getVictim().getName() + \" \" + accidentProtocol.getVictim().getSurname())")
    AccidentRegister registerFromProtocol(AccidentProtocol accidentProtocol);

}
