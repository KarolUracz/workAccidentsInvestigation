package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentInvestigator;

import java.util.List;

public interface AccidentInvestigatorService {
    List<AccidentInvestigator> findAll();
    void saveAccidentInvestigator(AccidentInvestigator accidentInvestigator);
    AccidentInvestigator readAccidentInvestigator(long id);
    void deleteAccidentInvestigator(long id);
}
