package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.AccidentEffectDto;
import pl.uracz.workAccident.entity.AccidentEffect;

import java.util.List;

public interface AccidentEffectService {
    List<AccidentEffect> findAll();
    void saveAccidentEffect(AccidentEffect accidentEffect);
    void saveAccidentEffect(AccidentEffectDto accidentEffectDto);
}
