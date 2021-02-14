package pl.uracz.workAccident.validation;

import pl.uracz.workAccident.dto.AccidentProtocolDto;
import pl.uracz.workAccident.entity.Company;
import pl.uracz.workAccident.repository.AccidentProtocolRepository;
import pl.uracz.workAccident.repository.CompanyRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProtocolNumberValidator implements ConstraintValidator<ProtocolNumberValidation, AccidentProtocolDto> {

    private AccidentProtocolRepository accidentProtocolRepository;
    private CompanyRepository companyRepository;

    public ProtocolNumberValidator(AccidentProtocolRepository accidentProtocolRepository, CompanyRepository companyRepository) {
        this.accidentProtocolRepository = accidentProtocolRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public void initialize(ProtocolNumberValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(AccidentProtocolDto accidentProtocolDto, ConstraintValidatorContext constraintValidatorContext) {
        Company byCompanyName = companyRepository.findByCompanyName(accidentProtocolDto.getCompanyDto().getCompanyName());
        boolean exists = !(accidentProtocolRepository
                .existsAccidentProtocolByProtocolNumberAndCompany(accidentProtocolDto.getProtocolNumber(), byCompanyName));
        return exists;
    }
}
