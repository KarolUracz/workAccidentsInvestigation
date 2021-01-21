package pl.uracz.workAccident.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.uracz.workAccident.dto.AccidentProtocolDto;
import pl.uracz.workAccident.service.AccidentProtocolService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccidentController {

    private AccidentProtocolService accidentProtocolService;

    public AccidentController(AccidentProtocolService accidentProtocolService) {
        this.accidentProtocolService = accidentProtocolService;
    }

    @PostMapping("/addAccident")
    public HttpStatus registerAccident (@RequestBody AccidentProtocolDto accidentProtocolDto) {
        accidentProtocolService.saveAccidentProtocol(accidentProtocolDto);
        return HttpStatus.OK;
    }

}
