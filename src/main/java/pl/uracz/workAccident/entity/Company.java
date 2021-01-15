package pl.uracz.workAccident.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String street;
    private String city;
    private String postalCode;
    private String taxIdentificationNumber;
    private String pkdNumber;
    @OneToMany
    private Set<AccidentInvestigator> accidentInvestigators;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public String getPkdNumber() {
        return pkdNumber;
    }

    public void setPkdNumber(String pkdNumber) {
        this.pkdNumber = pkdNumber;
    }

    public Set<AccidentInvestigator> getAccidentInvestigators() {
        return accidentInvestigators;
    }

    public void setAccidentInvestigators(Set<AccidentInvestigator> accidentInvestigators) {
        this.accidentInvestigators = accidentInvestigators;
    }
}
