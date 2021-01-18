package pl.uracz.workAccident.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.uracz.workAccident.service.AccidentProtocolService;

@RestController
@RequestMapping("/api")
public class AccidentStatsController {

    private AccidentProtocolService accidentProtocolService;

    public AccidentStatsController(AccidentProtocolService accidentProtocolService) {
        this.accidentProtocolService = accidentProtocolService;
    }

    @GetMapping("/stats")
    public String getAccidentStats() {
        return String.valueOf(accidentProtocolService.numberOfAccidents());
    }

}
