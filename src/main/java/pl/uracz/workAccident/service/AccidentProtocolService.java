package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentProtocol;

import java.util.List;

public interface AccidentProtocolService {
    List<AccidentProtocol> findAll();
    void saveAccidentProtocol(AccidentProtocol accidentProtocol);
    AccidentProtocol readAccidentProtocol(long id);
    void deleteAccidentProtocol(long id);
    Integer numberOfAccidents();
}
