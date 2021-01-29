package pl.uracz.workAccident.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UnfinishedProtocolDto {
    private String unfinishedProtocolNumber;
    private LocalDate accidentDate;
    private LocalDate reportedDate;
    private String victimFullName;
}
