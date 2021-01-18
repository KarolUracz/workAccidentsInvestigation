package pl.uracz.workAccident.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private String companyName;
    private String street;
    private String city;
    private String postalCode;
    private String taxIdentificationNumber;
    private String pkdNumber;
}
