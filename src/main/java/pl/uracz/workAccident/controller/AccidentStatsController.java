package pl.uracz.workAccident.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.uracz.workAccident.dto.DataSummary;
import pl.uracz.workAccident.service.AccidentProtocolService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccidentStatsController {

    private AccidentProtocolService accidentProtocolService;

    public AccidentStatsController(AccidentProtocolService accidentProtocolService) {
        this.accidentProtocolService = accidentProtocolService;
    }

    @GetMapping("/data-summary")
    public DataSummary getAccidentStats() {
        DataSummary dataSummary = new DataSummary();
        dataSummary.setUnfinishedProtocols(accidentProtocolService.findAllUnfinished());
        dataSummary.setNumberOfAccidents(accidentProtocolService.numberOfAccidents());
        return dataSummary;
    }

}
