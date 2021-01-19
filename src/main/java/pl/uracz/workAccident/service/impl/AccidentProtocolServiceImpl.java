package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.AccidentProtocol;
import pl.uracz.workAccident.repository.AccidentProtocolRepository;
import pl.uracz.workAccident.service.AccidentProtocolService;

import java.util.List;

@Service
public class AccidentProtocolServiceImpl implements AccidentProtocolService {

    private AccidentProtocolRepository accidentProtocolRepository;

    public AccidentProtocolServiceImpl(AccidentProtocolRepository accidentProtocolRepository) {
        this.accidentProtocolRepository = accidentProtocolRepository;
    }

    @Override
    public List<AccidentProtocol> findAll() {
        return accidentProtocolRepository.findAll();
    }

    @Override
    public void saveAccidentProtocol(AccidentProtocol accidentProtocol) {
        accidentProtocolRepository.save(accidentProtocol);
    }

    @Override
    public AccidentProtocol readAccidentProtocol(long id) {
        return accidentProtocolRepository.getOne(id);
    }

    @Override
    public void deleteAccidentProtocol(long id) {
        accidentProtocolRepository.deleteById(id);
    }

    @Override
    public Integer numberOfAccidents() {
        return accidentProtocolRepository.numberOfAccidents();
    }

    @Override
    public List<AccidentProtocol> findAllUnfinished() {
        return accidentProtocolRepository.findAllUnfinished();
    }
}
