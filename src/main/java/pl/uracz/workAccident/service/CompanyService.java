package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    void saveCompany(Company company);
    Company readCompany(long id);
    void deleteCompany(long id);
}
