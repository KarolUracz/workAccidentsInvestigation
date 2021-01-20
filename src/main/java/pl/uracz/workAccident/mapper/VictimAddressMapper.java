package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import pl.uracz.workAccident.dto.VictimAddressDto;
import pl.uracz.workAccident.entity.VictimAddress;

@Mapper(componentModel = "spring")
public interface VictimAddressMapper {

    VictimAddress victimAddressFromDto (VictimAddressDto victimAddressDto);
    VictimAddressDto dtoFromVictimAddress (VictimAddress victimAddress);
}
