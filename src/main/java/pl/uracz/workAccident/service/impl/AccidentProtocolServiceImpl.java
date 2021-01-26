package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.*;
import pl.uracz.workAccident.entity.*;
import pl.uracz.workAccident.mapper.*;
import pl.uracz.workAccident.repository.*;
import pl.uracz.workAccident.service.AccidentProtocolService;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccidentProtocolServiceImpl implements AccidentProtocolService {

    private AccidentProtocolRepository accidentProtocolRepository;
    private AccidentProtocolMapper accidentProtocolMapper;


    public AccidentProtocolServiceImpl(AccidentProtocolRepository accidentProtocolRepository,
                                       AccidentProtocolMapper accidentProtocolMapper) {
        this.accidentProtocolRepository = accidentProtocolRepository;
        this.accidentProtocolMapper = accidentProtocolMapper;
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
    public void saveAccidentProtocol(AccidentProtocolDto accidentProtocolDto) {
        AccidentProtocol accidentProtocol = accidentProtocolMapper.protocolFromDto(accidentProtocolDto);
        AccidentProtocol byProtocolNumber = accidentProtocolRepository.findByProtocolNumber(accidentProtocol.getProtocolNumber());
        if (byProtocolNumber != null) {
            accidentProtocol.setId(byProtocolNumber.getId());
        }
        accidentProtocolRepository.save(accidentProtocol);
    }

    @Override
    public AccidentProtocol readAccidentProtocol(long id) {
        return accidentProtocolRepository.getOne(id);
    }

    @Override
    public int deleteAccidentProtocol(String protocolNumber) {
         return accidentProtocolRepository.deleteAccidentProtocolByProtocolNumber(protocolNumber);
    }

    @Override
    public Integer numberOfAccidents() {
        return accidentProtocolRepository.numberOfAccidents();
    }

    //TODO: create mapper for below method
    @Override
    public List<UnfinishedProtocolDto> findAllUnfinished() {
        List<AccidentProtocol> allUnfinished = accidentProtocolRepository.findAllUnfinished();
        List<UnfinishedProtocolDto> allUnfinishedDto = new ArrayList<>();
        for (AccidentProtocol accidentProtocol : allUnfinished) {
            UnfinishedProtocolDto unfinishedProtocolDto = new UnfinishedProtocolDto();
            unfinishedProtocolDto.setUnfinishedProtocolNumber(accidentProtocol.getProtocolNumber());
            unfinishedProtocolDto.setAccidentDate(accidentProtocol.getAccidentDate());
            unfinishedProtocolDto.setReportedDate(accidentProtocol.getReportedDate());
            unfinishedProtocolDto.setVictimFullName(accidentProtocol.getVictim().getName() + " " + accidentProtocol.getVictim().getSurname());
            allUnfinishedDto.add(unfinishedProtocolDto);
        }
        return allUnfinishedDto;
    }

    @Override
    public AccidentProtocol findByProtocolNumber(String protocolNumber) {
        if (accidentProtocolRepository.existsAccidentProtocolByProtocolNumber(protocolNumber)) {
            AccidentProtocol byProtocolNumber = accidentProtocolRepository.findByProtocolNumber(protocolNumber);
            return byProtocolNumber;
        }
        return null;
    }

    @Override
    public boolean existByProtocolNumber(String protocolNumber) {
        return accidentProtocolRepository.existsAccidentProtocolByProtocolNumber(protocolNumber);
    }
}
