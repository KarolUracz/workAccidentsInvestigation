package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentRegister;
import pl.uracz.workAccident.entity.Company;

import java.util.List;

public interface AccidentRegisterService {
    List<AccidentRegister> findAll();
    List<AccidentRegister> findByCompany (Company company);
    AccidentRegister findByProtocolNumberAndCompany (String protocolNumber, Company company);
    void save(AccidentRegister accidentRegister);
    AccidentRegister update(AccidentRegister accidentRegister, String accidentPlace, int daysOfWorkAbsence, String dateOfDeliveryToZus);
}
