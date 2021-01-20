package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.AccidentTypeDto;
import pl.uracz.workAccident.entity.AccidentType;

import java.util.List;

public interface AccidentTypeService {
    List<AccidentType> findAll();
    void saveAccidentType(AccidentType accidentType);
    void saveAccidentType(AccidentTypeDto accidentTypeDto);
    AccidentType readAccidentType(long id);
    void deleteAccidentType(long id);
}
