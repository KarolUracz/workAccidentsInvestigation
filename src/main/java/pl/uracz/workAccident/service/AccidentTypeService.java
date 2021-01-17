package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentType;

import java.util.List;

public interface AccidentTypeService {
    List<AccidentType> findAll();
    void saveAccidentType(AccidentType accidentType);
    AccidentType readAccidentType(long id);
    void deleteAccidentType(long id);
}
