package pl.uracz.workAccident.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class UnfinishedProtocolDto {
    private String unfinishedProtocolNumber;
    private LocalDate accidentDate;
    private LocalDate reportedDate;
    private Set<VictimFullNameDto> victimFullNames;
}
