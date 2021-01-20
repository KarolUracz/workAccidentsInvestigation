package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.CompanyDto;
import pl.uracz.workAccident.entity.Company;
import pl.uracz.workAccident.mapper.CompanyMapper;
import pl.uracz.workAccident.repository.CompanyRepository;
import pl.uracz.workAccident.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
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
    public void saveCompany(CompanyDto companyDto) {
        Company company = companyMapper.companyDtoToCompany(companyDto);
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
