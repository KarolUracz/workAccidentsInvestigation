package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.AccidentCauseDto;
import pl.uracz.workAccident.entity.AccidentCause;

import java.util.List;

public interface AccidentCauseService {
    List<AccidentCause> findAll();
    void saveAccidentCause(AccidentCause accidentCause);
    void saveAccidentCause(AccidentCauseDto accidentCauseDto);
    AccidentCause readAccidentCause(long id);
    void deleteAccidentCause(long id);
}
