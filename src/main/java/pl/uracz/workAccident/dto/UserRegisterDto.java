package pl.uracz.workAccident.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String username;
    private String password;
    private CompanyDto companyDto;
}
