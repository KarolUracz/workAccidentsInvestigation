package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentProtocol;

import java.util.List;

public interface AccidentProtocolService {
    List<AccidentProtocol> findAll();
    boolean saveAccidentProtocol(AccidentProtocol accidentProtocol);
    AccidentProtocol readAccidentProtocol(long id);
    boolean updateAccidentProtocol(AccidentProtocol accidentProtocol);
    boolean deleteAccidentProtocol(long id);
}
