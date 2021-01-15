package pl.uracz.workAccident.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private LocalDate accidentProccedingEnd;
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

    public LocalDate getAccidentProccedingEnd() {
        return accidentProccedingEnd;
    }

    public void setAccidentProccedingEnd(LocalDate accidentProccedingEnd) {
        this.accidentProccedingEnd = accidentProccedingEnd;
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
}
