package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.AccidentInvestigatorDto;
import pl.uracz.workAccident.entity.AccidentInvestigator;
import pl.uracz.workAccident.entity.Company;
import pl.uracz.workAccident.mapper.AccidentInvestigatorMapper;
import pl.uracz.workAccident.mapper.CompanyMapper;
import pl.uracz.workAccident.repository.AccidentsInvestigatorRepository;
import pl.uracz.workAccident.repository.CompanyRepository;
import pl.uracz.workAccident.service.AccidentInvestigatorService;

import java.util.List;

@Service
public class AccidentInvestigatorServiceImpl implements AccidentInvestigatorService {

    private AccidentsInvestigatorRepository accidentsInvestigatorRepository;
    private AccidentInvestigatorMapper accidentInvestigatorMapper;
    private CompanyMapper companyMapper;
    private CompanyRepository companyRepository;

    public AccidentInvestigatorServiceImpl(AccidentsInvestigatorRepository accidentsInvestigatorRepository, AccidentInvestigatorMapper accidentInvestigatorMapper, CompanyMapper companyMapper, CompanyRepository companyRepository) {
        this.accidentsInvestigatorRepository = accidentsInvestigatorRepository;
        this.accidentInvestigatorMapper = accidentInvestigatorMapper;
        this.companyMapper = companyMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<AccidentInvestigator> findAll() {
        return accidentsInvestigatorRepository.findAll();
    }

    @Override
    public void saveAccidentInvestigator(AccidentInvestigator accidentInvestigator) {
        if (companyRepository.existsByCompanyName(accidentInvestigator.getCompany().getCompanyName())){
            accidentInvestigator.setCompany(companyRepository.findByCompanyName(accidentInvestigator.getCompany().getCompanyName()));
        } else {
            Company company = accidentInvestigator.getCompany();
            accidentInvestigator.setCompany(company);
            companyRepository.save(company);
        }
        accidentsInvestigatorRepository.save(accidentInvestigator);
    }

    @Override
    public void saveAccidentInvestigator(AccidentInvestigatorDto accidentInvestigatorDto) {
        AccidentInvestigator accidentInvestigator = accidentInvestigatorMapper.accidentInvestigatorFromDto(accidentInvestigatorDto);
        accidentsInvestigatorRepository.save(accidentInvestigator);
    }

    @Override
    public AccidentInvestigator readAccidentInvestigator(long id) {
        return accidentsInvestigatorRepository.getOne(id);
    }

    @Override
    public void deleteAccidentInvestigator(long id) {
        accidentsInvestigatorRepository.deleteById(id);
    }
}
