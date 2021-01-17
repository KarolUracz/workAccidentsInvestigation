package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.Victim;

import java.util.List;

public interface VictimService {
    List<Victim> findAll();
    void saveVictim (Victim victim);
    Victim readVictim (long id);
    void deleteVictim (long id);
}
