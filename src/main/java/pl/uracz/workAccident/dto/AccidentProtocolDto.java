package pl.uracz.workAccident.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;


@Data
public class AccidentProtocolDto {

    private String protocolNumber;
    private CompanyDto companyDto;
    private Set<AccidentInvestigatorDto> accidentInvestigatorsDto;
    private LocalDate accidentProceedingStart;
    private LocalDate accidentProceedingEnd;
    private LocalDate accidentDate;
    private LocalTime accidentTime;
    private Set<VictimDto> victimDto;
    private String reportedBy;
    private LocalDate reportedDate;
    private String accidentCircumstances;
    private Set<AccidentCauseDto> accidentCausesDto;
    private boolean employerFault;
    private boolean employeeFault;
    private boolean employeeIntoxication;
    private Set<AccidentEffectDto> accidentEffectsDto;
    private boolean isAccidentAtWork;
    private String accidentReason;
    private Set<AccidentTypeDto> accidentTypeDto;
    private Set<AfterAccidentRecommendationDto> afterAccidentRecommendationsDto;
    private LocalDate dateOfPreparation;
    private String obstaclesOfPreparationInTerm;
    private Set<ProtocolAttachmentDto> protocolAttachmentsDto;
    private boolean finishedProtocol;

}
