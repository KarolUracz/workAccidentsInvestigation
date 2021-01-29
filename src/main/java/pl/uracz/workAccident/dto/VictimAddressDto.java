package pl.uracz.workAccident.dto;

import lombok.Data;

@Data
public class VictimAddressDto {
    private String postCode;
    private String city;
    private String street;
    private String houseNumber;
    private Integer apartmentNumber;
    private String peselNumber;
    private String identificationDocumentNumber;
}
