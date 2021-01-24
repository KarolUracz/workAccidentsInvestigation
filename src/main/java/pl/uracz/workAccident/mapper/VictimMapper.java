package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.VictimDto;
import pl.uracz.workAccident.entity.Victim;

@Mapper(componentModel = "spring", uses = {VictimAddressMapper.class})
public interface VictimMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", source = "addressDto")
    Victim victimFromDto (VictimDto victimDto);
    @Mapping(target = "addressDto", source = "address")
    VictimDto dtoFromVictim (Victim victim);

}
