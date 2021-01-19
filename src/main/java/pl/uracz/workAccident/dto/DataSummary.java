package pl.uracz.workAccident.dto;

import lombok.Data;
import pl.uracz.workAccident.entity.AccidentProtocol;

import java.util.List;

@Data
public class DataSummary {
    private Integer numberOfAccidents;
    private List<AccidentProtocol> unfinishedProtocols;
}
