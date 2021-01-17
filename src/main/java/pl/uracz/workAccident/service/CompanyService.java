package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    boolean saveCompany(Company company);
    Company readCompany(long id);
    boolean updateCompany(Company company);
    boolean deleteCompany(long id);
}
