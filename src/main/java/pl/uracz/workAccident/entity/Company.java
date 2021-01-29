package pl.uracz.workAccident.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
}
