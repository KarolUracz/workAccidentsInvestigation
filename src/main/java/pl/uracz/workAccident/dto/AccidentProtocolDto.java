package pl.uracz.workAccident.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private Set<AccidentTypeDto> accidentTypeDto;
    private Set<AfterAccidentRecommendationDto> afterAccidentRecommendationsDto;
    private LocalDate dateOfPreparation;
    private String obstaclesOfPreparationInTerm;
    private Set<ProtocolAttachmentDto> protocolAttachmentsDto;
    private boolean finishedProtocol;

}
