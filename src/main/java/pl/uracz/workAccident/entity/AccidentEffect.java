package pl.uracz.workAccident.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccidentEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accidentEffect;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccidentEffect() {
        return accidentEffect;
    }

    public void setAccidentEffect(String accidentEffect) {
        this.accidentEffect = accidentEffect;
    }
}
