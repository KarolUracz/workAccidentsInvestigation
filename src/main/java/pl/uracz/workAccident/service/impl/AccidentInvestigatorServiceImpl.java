package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.AccidentInvestigator;
import pl.uracz.workAccident.repository.AccidentsInvestigatorRepository;
import pl.uracz.workAccident.service.AccidentInvestigatorService;

import java.util.List;

@Service
public class AccidentInvestigatorServiceImpl implements AccidentInvestigatorService {

    private AccidentsInvestigatorRepository accidentsInvestigatorRepository;

    public AccidentInvestigatorServiceImpl(AccidentsInvestigatorRepository accidentsInvestigatorRepository) {
        this.accidentsInvestigatorRepository = accidentsInvestigatorRepository;
    }

    @Override
    public List<AccidentInvestigator> findAll() {
        return accidentsInvestigatorRepository.findAll();
    }

    @Override
    public void saveAccidentInvestigator(AccidentInvestigator accidentInvestigator) {
        accidentsInvestigatorRepository.save(accidentInvestigator);
    }

    @Override
    public AccidentInvestigator readAccidentInvestigator(long id) {
        return accidentsInvestigatorRepository.getOne(id);
    }

    @Override
    public void deleteAccidentInvestigator(long id) {
        accidentsInvestigatorRepository.deleteById(id);
    }
}
