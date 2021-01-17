package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.Company;
import pl.uracz.workAccident.repository.CompanyRepository;
import pl.uracz.workAccident.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company readCompany(long id) {
        return companyRepository.getOne(id);
    }

    @Override
    public void deleteCompany(long id) {
        companyRepository.deleteById(id);
    }
}
