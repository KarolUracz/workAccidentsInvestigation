package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import pl.uracz.workAccident.dto.VictimAddressDto;
import pl.uracz.workAccident.dto.VictimDto;
import pl.uracz.workAccident.dto.VictimFullNameDto;
import pl.uracz.workAccident.entity.Victim;
import pl.uracz.workAccident.entity.VictimAddress;

@Mapper(componentModel = "spring")
public interface VictimMapper {

    Victim victimFromDto (VictimDto victimDto);
    VictimDto dtoFromVictim (Victim victim);

}
