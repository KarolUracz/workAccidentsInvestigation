package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.CompanyDto;
import pl.uracz.workAccident.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    void saveCompany(Company company);
    void saveCompany(CompanyDto companyDto);
    Company readCompany(long id);
    void deleteCompany(long id);
    Company findByName(String name);
    boolean existByCompanyName(String name);
}
