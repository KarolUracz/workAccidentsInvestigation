package pl.uracz.workAccident.dto;

import lombok.Data;
import pl.uracz.workAccident.entity.Company;

@Data
public class CompanyDto {
    private String companyName;
    private String street;
    private String city;
    private String postalCode;
    private String taxIdentificationNumber;
    private String pkdNumber;

    public Company fromDtoToCompany(){
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setStreet(street);
        company.setCity(city);
        company.setPostalCode(postalCode);
        company.setTaxIdentificationNumber(taxIdentificationNumber);
        company.setPkdNumber(pkdNumber);
        return company;
    }
}
