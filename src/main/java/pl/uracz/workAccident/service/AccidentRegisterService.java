package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.AccidentRegister;

import java.util.List;

public interface AccidentRegisterService {
    List<AccidentRegister> findAll();

}