package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.AccidentRegister;
import pl.uracz.workAccident.entity.Company;
import pl.uracz.workAccident.repository.AccidentRegisterRepository;
import pl.uracz.workAccident.service.AccidentRegisterService;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccidentRegisterServiceImpl implements AccidentRegisterService {

    private AccidentRegisterRepository accidentRegisterRepository;

    public AccidentRegisterServiceImpl(AccidentRegisterRepository accidentRegisterRepository) {
        this.accidentRegisterRepository = accidentRegisterRepository;
    }

    @Override
    public List<AccidentRegister> findAll() {
        return accidentRegisterRepository.findAll();
    }

    @Override
    public List<AccidentRegister> findByCompany(Company company) {
        return accidentRegisterRepository.findByCompany(company);
    }

    @Override
    public AccidentRegister findByProtocolNumberAndCompany(String protocolNumber, Company company) {
        return accidentRegisterRepository.findByProtocolNumberAndCompany(protocolNumber, company);
    }

    @Override
    public void save(AccidentRegister accidentRegister) {
        accidentRegisterRepository.save(accidentRegister);
    }

    @Override
    public AccidentRegister update(AccidentRegister accidentRegister, String accidentPlace, int daysOfWorkAbsence, String dateOfDeliveryToZus) {
        accidentRegister.setAccidentPlace(accidentPlace);
        accidentRegister.setDaysOfWorkAbsence(daysOfWorkAbsence);
        accidentRegister.setDateOfDeliveryToZus(LocalDate.parse(dateOfDeliveryToZus));
        return accidentRegister;
    }
}
