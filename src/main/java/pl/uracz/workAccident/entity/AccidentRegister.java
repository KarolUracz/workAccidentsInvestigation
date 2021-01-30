package pl.uracz.workAccident.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class AccidentRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String protocolNumber;
    private LocalDate dateOfPreparation;
    private String victimFullName;
    private String accidentPlace;
    private LocalDate accidentDate;
    @OneToMany
    private List<AccidentEffect> accidentEffects;
    private int daysOfWorkAbsence;
    private boolean isAccidentAtWork;
    private LocalDate dateOfDeliveryToZus;
    @OneToMany
    private List<AfterAccidentRecommendation> afterAccidentRecommendations;
    @ManyToOne
    private Company company;
}
