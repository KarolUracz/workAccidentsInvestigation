package pl.uracz.workAccident.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Victim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    @OneToOne(cascade = CascadeType.ALL)
    private VictimAddress address;
    private String workDepartment;
    private String workplace;
    private String professionCode;
}
