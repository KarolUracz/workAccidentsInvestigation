package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.repository.AccidentsInvestigatorRepository;
import pl.uracz.workAccident.service.AccidentInvestigatorService;

@Service
public class AccidentInvestigatorServiceImpl implements AccidentInvestigatorService {

    private AccidentsInvestigatorRepository accidentsInvestigatorRepository;

    public AccidentInvestigatorServiceImpl(AccidentsInvestigatorRepository accidentsInvestigatorRepository) {
        this.accidentsInvestigatorRepository = accidentsInvestigatorRepository;
    }
}
