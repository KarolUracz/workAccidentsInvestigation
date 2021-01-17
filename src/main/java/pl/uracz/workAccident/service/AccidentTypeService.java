package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentType;

import java.util.List;

public interface AccidentTypeService {
    List<AccidentType> findAll();
    boolean saveAccidentType(AccidentType accidentType);
    AccidentType readAccidentType(long id);
    boolean updateAccidentType(AccidentType accidentType);
    boolean deleteAccidentType(long id);
}
