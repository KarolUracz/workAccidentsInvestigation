package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.CompanyDto;
import pl.uracz.workAccident.entity.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mapping(target = "id", ignore = true)
    Company companyDtoToCompany(CompanyDto companyDto);
    CompanyDto companyToDto(Company company);
}
