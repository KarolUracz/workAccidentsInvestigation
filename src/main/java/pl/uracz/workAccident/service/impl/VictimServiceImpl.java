package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.VictimDto;
import pl.uracz.workAccident.entity.Victim;
import pl.uracz.workAccident.mapper.VictimMapper;
import pl.uracz.workAccident.repository.VictimRepository;
import pl.uracz.workAccident.service.VictimService;

import java.util.List;

@Service
public class VictimServiceImpl implements VictimService {

    private VictimRepository victimRepository;
    private VictimMapper victimMapper;

    public VictimServiceImpl(VictimRepository victimRepository, VictimMapper victimMapper) {
        this.victimRepository = victimRepository;
        this.victimMapper = victimMapper;
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
    public void saveVictim(VictimDto victimDto) {
        Victim victim = victimMapper.victimFromDto(victimDto);
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
