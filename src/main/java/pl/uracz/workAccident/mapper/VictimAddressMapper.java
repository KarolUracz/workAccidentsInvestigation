package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.VictimAddressDto;
import pl.uracz.workAccident.entity.VictimAddress;

@Mapper(componentModel = "spring")
public interface VictimAddressMapper {

    @Mapping(target = "id", ignore = true)
    VictimAddress victimAddressFromDto (VictimAddressDto victimAddressDto);
    VictimAddressDto dtoFromVictimAddress (VictimAddress victimAddress);
}
