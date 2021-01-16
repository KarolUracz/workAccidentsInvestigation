package pl.uracz.workAccident.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;
import java.util.Set;

@Entity
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
    private Set<ProtolAttachment> protolAttachments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<AccidentInvestigator> getAccidentInvestigators() {
        return accidentInvestigators;
    }

    public void setAccidentInvestigators(Set<AccidentInvestigator> accidentInvestigators) {
        this.accidentInvestigators = accidentInvestigators;
    }

    public LocalDate getAccidentProceedingStart() {
        return accidentProceedingStart;
    }

    public void setAccidentProceedingStart(LocalDate accidentProceedingStart) {
        this.accidentProceedingStart = accidentProceedingStart;
    }

    public LocalDate getAccidentProceedingEnd() {
        return accidentProceedingEnd;
    }

    public void setAccidentProceedingEnd(LocalDate accidentProccedingEnd) {
        this.accidentProceedingEnd = accidentProccedingEnd;
    }

    public LocalDate getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }

    public LocalTime getAccidentTime() {
        return accidentTime;
    }

    public void setAccidentTime(LocalTime accidentTime) {
        this.accidentTime = accidentTime;
    }

    public Set<Victim> getVictim() {
        return victim;
    }

    public void setVictim(Set<Victim> victim) {
        this.victim = victim;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getAccidentCircumstances() {
        return accidentCircumstances;
    }

    public void setAccidentCircumstances(String accidentCircumstances) {
        this.accidentCircumstances = accidentCircumstances;
    }

    public Set<AccidentCause> getAccidentCauses() {
        return accidentCauses;
    }

    public void setAccidentCauses(Set<AccidentCause> accidentCauses) {
        this.accidentCauses = accidentCauses;
    }

    public boolean isEmployerFault() {
        return employerFault;
    }

    public void setEmployerFault(boolean employerFault) {
        this.employerFault = employerFault;
    }

    public boolean isEmployeeFault() {
        return employeeFault;
    }

    public void setEmployeeFault(boolean employeeFault) {
        this.employeeFault = employeeFault;
    }

    public boolean isEmployeeIntoxication() {
        return employeeIntoxication;
    }

    public void setEmployeeIntoxication(boolean employeeIntoxication) {
        this.employeeIntoxication = employeeIntoxication;
    }

    public Set<AccidentEffect> getAccidentEffects() {
        return accidentEffects;
    }

    public void setAccidentEffects(Set<AccidentEffect> accidentEffects) {
        this.accidentEffects = accidentEffects;
    }

    public boolean isAccidentAtWork() {
        return isAccidentAtWork;
    }

    public void setAccidentAtWork(boolean accidentAtWork) {
        isAccidentAtWork = accidentAtWork;
    }

    public String getAccidentReason() {
        return accidentReason;
    }

    public void setAccidentReason(String accidentReason) {
        this.accidentReason = accidentReason;
    }

    public Set<AccidentType> getAccidentType() {
        return accidentType;
    }

    public void setAccidentType(Set<AccidentType> accidentType) {
        this.accidentType = accidentType;
    }

    public Set<AfterAccidentRecommendation> getAfterAccidentRecommendations() {
        return afterAccidentRecommendations;
    }

    public void setAfterAccidentRecommendations(Set<AfterAccidentRecommendation> afterAccidentRecommendations) {
        this.afterAccidentRecommendations = afterAccidentRecommendations;
    }

    public LocalDate getDateOfPreparation() {
        return dateOfPreparation;
    }

    public void setDateOfPreparation(LocalDate dateOfPreparation) {
        this.dateOfPreparation = dateOfPreparation;
    }

    public String getObstaclesOfPreparationInTerm() {
        return obstaclesOfPreparationInTerm;
    }

    public void setObstaclesOfPreparationInTerm(String obstaclesOfPreparationInTerm) {
        this.obstaclesOfPreparationInTerm = obstaclesOfPreparationInTerm;
    }
}
