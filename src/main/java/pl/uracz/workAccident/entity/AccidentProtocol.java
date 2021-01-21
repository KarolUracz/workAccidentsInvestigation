package pl.uracz.workAccident.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
public class AccidentProtocol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String protocolNumber;
    @OneToOne
    private Company company;
    @OneToMany
    private Set<AccidentInvestigator> accidentInvestigators;
    private LocalDate accidentProceedingStart;
    private LocalDate accidentProceedingEnd;
    private LocalDate accidentDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime accidentTime;
    @OneToMany
    private Set<Victim> victim;
    private String reportedBy;
    private LocalDate reportedDate;
    private String accidentCircumstances;
    @OneToMany
    private Set<AccidentCause> accidentCauses;
    private String employerFault;
    private String employeeFault;
    private String employeeIntoxication;
    @OneToMany
    private Set<AccidentEffect> accidentEffects;
    private boolean isAccidentAtWork;
    private String accidentReason;
    @OneToMany
    private Set<AccidentType> accidentType;
    @OneToMany
    private Set<AfterAccidentRecommendation> afterAccidentRecommendations;
    private LocalDate dateOfPreparation;
    private String obstaclesOfPreparationInTerm;
    @OneToMany
    private Set<ProtocolAttachment> protocolAttachments;
    private boolean finishedProtocol;
}
