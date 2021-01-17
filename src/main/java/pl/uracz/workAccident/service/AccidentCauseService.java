package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentCause;

import java.util.List;

public interface AccidentCauseService {
    List<AccidentCause> findAll();
    boolean saveAccidentCause(AccidentCause accidentCause);
    AccidentCause readAccidentCause(long id);
    boolean updateAccidentCause(AccidentCause accidentCause);
    boolean deleteAccidentCause(long id);
}
