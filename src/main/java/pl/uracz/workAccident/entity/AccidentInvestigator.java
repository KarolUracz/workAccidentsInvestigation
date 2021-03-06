package pl.uracz.workAccident.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AccidentInvestigator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String workPosition;
    @ManyToOne
    private Company company;
}
