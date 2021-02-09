package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.AccidentCauseDto;
import pl.uracz.workAccident.entity.AccidentCause;
import pl.uracz.workAccident.mapper.AccidentCauseMapper;
import pl.uracz.workAccident.repository.AccidentCauseRepository;
import pl.uracz.workAccident.service.AccidentCauseService;

import java.util.List;

@Service
public class AccidentCauseServiceImpl implements AccidentCauseService {

    private AccidentCauseRepository accidentCauseRepository;
    private AccidentCauseMapper accidentCauseMapper;

    public AccidentCauseServiceImpl(AccidentCauseRepository accidentCauseRepository, AccidentCauseMapper accidentCauseMapper) {
        this.accidentCauseRepository = accidentCauseRepository;
        this.accidentCauseMapper = accidentCauseMapper;
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
    public void saveAccidentCause(AccidentCauseDto accidentCauseDto) {
        AccidentCause accidentCause = accidentCauseMapper.accidentCauseFromDto(accidentCauseDto);
        accidentCauseRepository.save(accidentCause);
    }
}
