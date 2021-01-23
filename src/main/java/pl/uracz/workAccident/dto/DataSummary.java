package pl.uracz.workAccident.dto;

import lombok.Data;

import java.util.List;

@Data
public class DataSummary {
    private Integer numberOfAccidents;
    private List<UnfinishedProtocolDto> unfinishedProtocols;
}
