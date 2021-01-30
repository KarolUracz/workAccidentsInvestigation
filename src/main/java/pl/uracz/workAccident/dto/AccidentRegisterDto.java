package pl.uracz.workAccident.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class AccidentRegisterDto {
    private String protocolNumber;
    private LocalDate dateOfPreparation;
    private String victimFullName;
    private String accidentPlace;
    private LocalDate accidentDate;
    private List<AccidentEffectDto> accidentEffectDtos;
    private int daysOfWorkAbsence;
    private boolean isAccidentAtWork;
    private LocalDate dateOfDeliveryToZus;
    private List<AfterAccidentRecommendationDto> afterAccidentRecommendationDtos;
}
