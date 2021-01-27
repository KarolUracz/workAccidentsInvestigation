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
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private Company company;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private Set<AccidentInvestigator> accidentInvestigators;
    private LocalDate accidentProceedingStart;
    private LocalDate accidentProceedingEnd;
    private LocalDate accidentDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime accidentTime;
    @OneToOne(cascade = CascadeType.ALL)
    private Victim victim;
    private String reportedBy;
    private LocalDate reportedDate;
    private String accidentCircumstances;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<AccidentCause> accidentCauses;
    private String employerFault;
    private String employeeFault;
    private String employeeIntoxication;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<AccidentEffect> accidentEffects;
    private boolean isAccidentAtWork;
    private String accidentReason;
    private boolean individualAccident;
    private boolean collectiveAccident;
    private boolean fatalAccident;
    private boolean seriousAccident;
    private boolean workAbsence;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<AfterAccidentRecommendation> afterAccidentRecommendations;
    private LocalDate dateOfPreparation;
    private String obstaclesOfPreparationInTerm;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProtocolAttachment> protocolAttachments;
    private boolean finishedProtocol;
    @ManyToOne
    private User user;
}
