package pl.uracz.workAccident.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalTime accidentTime;
    @OneToMany
    private Set<Victim> victim;
    private String reportedBy;
    private LocalDate reportedDate;
    private String accidentCircumstances;
    @OneToMany
    private Set<AccidentCause> accidentCauses;
    private boolean employerFault;
    private boolean employeeFault;
    private boolean employeeIntoxication;
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
