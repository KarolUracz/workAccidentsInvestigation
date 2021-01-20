package pl.uracz.workAccident.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.uracz.workAccident.dto.AccidentProtocolDto;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccidentController {

    @PostMapping("/addAccident")
    public HttpStatus registerAccident (@RequestBody AccidentProtocolDto accidentProtocolDto) {

        return HttpStatus.OK;
    }

}
