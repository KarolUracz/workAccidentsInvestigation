package pl.uracz.workAccident.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccidentCause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accidentCause;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccidentCause() {
        return accidentCause;
    }

    public void setAccidentCause(String accidentCause) {
        this.accidentCause = accidentCause;
    }
}
