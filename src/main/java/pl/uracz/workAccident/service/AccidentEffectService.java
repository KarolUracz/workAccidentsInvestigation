package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentEffect;

import java.util.List;

public interface AccidentEffectService {
    List<AccidentEffect> findAll();
    void saveAccidentEffect(AccidentEffect accidentEffect);
    AccidentEffect readAccidentEffect(long id);
    void deleteAccidentEffect(long id);
}
