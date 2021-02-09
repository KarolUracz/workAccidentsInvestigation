package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.AccidentEffectDto;
import pl.uracz.workAccident.entity.AccidentEffect;
import pl.uracz.workAccident.mapper.AccidentEffectMapper;
import pl.uracz.workAccident.repository.AccidentEffectRepository;
import pl.uracz.workAccident.service.AccidentEffectService;

import java.util.List;

@Service
public class AccidentEffectServiceImpl implements AccidentEffectService {

    private AccidentEffectRepository accidentEffectRepository;
    private AccidentEffectMapper accidentEffectMapper;

    public AccidentEffectServiceImpl(AccidentEffectRepository accidentEffectRepository, AccidentEffectMapper accidentEffectMapper) {
        this.accidentEffectRepository = accidentEffectRepository;
        this.accidentEffectMapper = accidentEffectMapper;
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
    public void saveAccidentEffect(AccidentEffectDto accidentEffectDto) {
        AccidentEffect accidentEffect = accidentEffectMapper.accidentEffectFromDto(accidentEffectDto);
        accidentEffectRepository.save(accidentEffect);
    }
}
