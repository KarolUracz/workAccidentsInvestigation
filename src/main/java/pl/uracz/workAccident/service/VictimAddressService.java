package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.VictimAddress;

import java.util.List;

public interface VictimAddressService {
    List<VictimAddress> findAll();
    boolean saveVictimAddress(VictimAddress victimAddress);
    VictimAddress readVictimAddress(long id);
    boolean updateVictimAddress(VictimAddress victimAddress);
    boolean deleteVictimAddress(long id);
}
