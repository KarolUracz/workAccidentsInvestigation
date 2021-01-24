package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.AccidentProtocolDto;
import pl.uracz.workAccident.dto.UnfinishedProtocolDto;
import pl.uracz.workAccident.entity.AccidentProtocol;

import java.util.List;

public interface AccidentProtocolService {
    List<AccidentProtocol> findAll();
    void saveAccidentProtocol(AccidentProtocol accidentProtocol);
    void saveAccidentProtocol(AccidentProtocolDto accidentProtocolDto);
    AccidentProtocol readAccidentProtocol(long id);
    void deleteAccidentProtocol(long id);
    Integer numberOfAccidents();
    List<UnfinishedProtocolDto> findAllUnfinished();
    AccidentProtocolDto findByProtocolNumber (String protocolNumber);
}
