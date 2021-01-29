package pl.uracz.workAccident.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VictimDto {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private VictimAddressDto addressDto;
    private String workDepartment;
    private String workplace;
    private String professionCode;
}
