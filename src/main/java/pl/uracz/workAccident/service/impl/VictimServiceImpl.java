package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.Victim;
import pl.uracz.workAccident.repository.VictimRepository;
import pl.uracz.workAccident.service.VictimService;

import java.util.List;

@Service
public class VictimServiceImpl implements VictimService {

    private VictimRepository victimRepository;

    public VictimServiceImpl(VictimRepository victimRepository) {
        this.victimRepository = victimRepository;
    }

    @Override
    public List<Victim> findAll() {
        return victimRepository.findAll();
    }

    @Override
    public void saveVictim(Victim victim) {
        victimRepository.save(victim);
    }

    @Override
    public Victim readVictim(long id) {
        return victimRepository.getOne(id);
    }

    @Override
    public void deleteVictim(long id) {
        victimRepository.deleteById(id);
    }
}
