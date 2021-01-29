package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.AccidentProtocolDto;
import pl.uracz.workAccident.dto.UnfinishedProtocolDto;
import pl.uracz.workAccident.entity.AccidentProtocol;
import pl.uracz.workAccident.entity.User;

import java.util.List;

public interface AccidentProtocolService {
    List<AccidentProtocol> findAll();
    void saveAccidentProtocol(AccidentProtocolDto accidentProtocolDto, User user);
    AccidentProtocol readAccidentProtocol(long id);
    int deleteAccidentProtocol(String protocolNumber);
    Integer numberOfAccidents();
    List<UnfinishedProtocolDto> findAllUnfinished();
    AccidentProtocol findByProtocolNumber (String protocolNumber);
    void updateAccident(AccidentProtocol accidentProtocol);
    AccidentProtocol findById (long id);
}
