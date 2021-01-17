package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.Company;
import pl.uracz.workAccident.entity.Victim;

import java.util.List;

public interface VictimService {
    List<Victim> findAll();
    boolean saveVictim (Victim victim);
    Victim readVictim (long id);
    boolean updateVictim (Victim victim);
    boolean deleteVictim (long id);
}
