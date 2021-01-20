package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.VictimAddressDto;
import pl.uracz.workAccident.entity.VictimAddress;

import java.util.List;

public interface VictimAddressService {
    List<VictimAddress> findAll();
    void saveVictimAddress(VictimAddress victimAddress);
    void saveVictimAddress(VictimAddressDto victimAddressDto);
    VictimAddress readVictimAddress(long id);
    void deleteVictimAddress(long id);
}
