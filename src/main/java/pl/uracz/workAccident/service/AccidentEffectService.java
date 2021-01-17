package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentEffect;

import java.util.List;

public interface AccidentEffectService {
    List<AccidentEffect> findAll();
    boolean saveAccidentEffect(AccidentEffect accidentEffect);
    AccidentEffect readAccidentEffect(long id);
    boolean updateAccidentEffect(AccidentEffect accidentEffect);
    boolean deleteAccidentEffect(long id);
}
