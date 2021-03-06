package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.AccidentProtocolDto;
import pl.uracz.workAccident.dto.UnfinishedProtocolDto;
import pl.uracz.workAccident.entity.AccidentProtocol;
import pl.uracz.workAccident.entity.User;

import java.util.List;

public interface AccidentProtocolService {
    List<AccidentProtocol> findAll();
    AccidentProtocol saveAccidentProtocol(AccidentProtocolDto accidentProtocolDto, User user);
    int deleteAccidentProtocol(String protocolNumber);
    Integer numberOfAccidents();
    List<UnfinishedProtocolDto> findAllUnfinished();
    AccidentProtocol findByProtocolNumber (String protocolNumber);
    void updateAccident(AccidentProtocol accidentProtocol);
    AccidentProtocol findById (long id);
    void save(AccidentProtocol accidentProtocol);
    void finishProtocol(AccidentProtocol accidentProtocol, User byUsername);
}
