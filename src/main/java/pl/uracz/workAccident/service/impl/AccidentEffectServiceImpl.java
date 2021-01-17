package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.AccidentEffect;
import pl.uracz.workAccident.repository.AccidentEffectRepository;
import pl.uracz.workAccident.service.AccidentEffectService;

import java.util.List;

@Service
public class AccidentEffectServiceImpl implements AccidentEffectService {

    private AccidentEffectRepository accidentEffectRepository;

    public AccidentEffectServiceImpl(AccidentEffectRepository accidentEffectRepository) {
        this.accidentEffectRepository = accidentEffectRepository;
    }

    @Override
    public List<AccidentEffect> findAll() {
        return accidentEffectRepository.findAll();
    }

    @Override
    public void saveAccidentEffect(AccidentEffect accidentEffect) {
        accidentEffectRepository.save(accidentEffect);
    }

    @Override
    public AccidentEffect readAccidentEffect(long id) {
        return accidentEffectRepository.getOne(id);
    }

    @Override
    public void deleteAccidentEffect(long id) {
        accidentEffectRepository.deleteById(id);
    }
}
