package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.AccidentType;
import pl.uracz.workAccident.repository.AccidentTypeRepository;
import pl.uracz.workAccident.service.AccidentTypeService;

import java.util.List;

@Service
public class AccidentTypeServiceImpl implements AccidentTypeService {

    private AccidentTypeRepository accidentTypeRepository;

    public AccidentTypeServiceImpl(AccidentTypeRepository accidentTypeRepository) {
        this.accidentTypeRepository = accidentTypeRepository;
    }

    @Override
    public List<AccidentType> findAll() {
        return accidentTypeRepository.findAll();
    }

    @Override
    public void saveAccidentType(AccidentType accidentType) {
        accidentTypeRepository.save(accidentType);
    }

    @Override
    public AccidentType readAccidentType(long id) {
        return accidentTypeRepository.getOne(id);
    }

    @Override
    public void deleteAccidentType(long id) {
        accidentTypeRepository.deleteById(id);
    }
}
