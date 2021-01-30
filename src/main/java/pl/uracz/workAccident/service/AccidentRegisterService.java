package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentRegister;
import pl.uracz.workAccident.entity.Company;

import java.util.List;

public interface AccidentRegisterService {
    List<AccidentRegister> findAll();
    List<AccidentRegister> findByCompany (Company company);
}
