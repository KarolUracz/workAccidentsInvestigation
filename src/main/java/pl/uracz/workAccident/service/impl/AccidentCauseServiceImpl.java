package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.AccidentCause;
import pl.uracz.workAccident.repository.AccidentCauseRepository;
import pl.uracz.workAccident.service.AccidentCauseService;

import java.util.List;

@Service
public class AccidentCauseServiceImpl implements AccidentCauseService {

    private AccidentCauseRepository accidentCauseRepository;

    public AccidentCauseServiceImpl(AccidentCauseRepository accidentCauseRepository) {
        this.accidentCauseRepository = accidentCauseRepository;
    }

    @Override
    public List<AccidentCause> findAll() {
        return accidentCauseRepository.findAll();
    }

    @Override
    public void saveAccidentCause(AccidentCause accidentCause) {
        accidentCauseRepository.save(accidentCause);
    }

    @Override
    public AccidentCause readAccidentCause(long id) {
        return accidentCauseRepository.getOne(id);
    }

    @Override
    public void deleteAccidentCause(long id) {
        accidentCauseRepository.deleteById(id);
    }
}
