package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.VictimAddress;

import java.util.List;

public interface VictimAddressService {
    List<VictimAddress> findAll();
    void saveVictimAddress(VictimAddress victimAddress);
    VictimAddress readVictimAddress(long id);
    void deleteVictimAddress(long id);
}
