package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import pl.uracz.workAccident.dto.CompanyDto;
import pl.uracz.workAccident.entity.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company companyDtoToCompany(CompanyDto companyDto);
    CompanyDto companyToDto(Company company);
}
