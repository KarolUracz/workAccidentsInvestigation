package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentInvestigator;

import java.util.List;

public interface AccidentInvestigatorService {
    List<AccidentInvestigator> findAll();
    boolean saveAccidentInvestigator(AccidentInvestigator company);
    AccidentInvestigator readAccidentInvestigator(long id);
    boolean updateAccidentInvestigator(AccidentInvestigator company);
    boolean deleteAccidentInvestigator(long id);
}
