package pl.uracz.workAccident.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import pl.uracz.workAccident.validation.ProtocolNumberValidation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@ProtocolNumberValidation
public class AccidentProtocolDto {

    private String protocolNumber;
    private CompanyDto companyDto;
    private Set<AccidentInvestigatorDto> accidentInvestigatorsDto;
    private LocalDate accidentProceedingStart;
    private LocalDate accidentProceedingEnd;
    private LocalDate accidentDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime accidentTime;
    private VictimDto victimDto;
    private String reportedBy;
    private LocalDate reportedDate;
    private String accidentCircumstances;
    private Set<AccidentCauseDto> accidentCausesDto;
    private String employerFault;
    private String employeeFault;
    private String employeeIntoxication;
    private Set<AccidentEffectDto> accidentEffectsDto;
    private boolean isAccidentAtWork;
    private String accidentReason;
    private boolean individualAccident;
    private boolean collectiveAccident;
    private boolean fatalAccident;
    private boolean seriousAccident;
    private boolean workAbsence;
    private Set<AfterAccidentRecommendationDto> afterAccidentRecommendationsDto;
    private LocalDate dateOfPreparation;
    private String obstaclesOfPreparationInTerm;
    private Set<ProtocolAttachmentDto> protocolAttachmentsDto;
    private boolean finishedProtocol = false;
}
