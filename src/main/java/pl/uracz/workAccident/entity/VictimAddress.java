package pl.uracz.workAccident.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class VictimAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postCode;
    private String city;
    private String street;
    private String houseNumber;
    private Integer apartmentNumber;
    private String peselNumber;
    private String identificationDocumentNumber;
}
