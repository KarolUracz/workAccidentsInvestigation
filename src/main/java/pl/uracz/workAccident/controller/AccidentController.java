package pl.uracz.workAccident.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.uracz.workAccident.dto.AccidentProtocolDto;
import pl.uracz.workAccident.entity.AccidentProtocol;

@RestController
@RequestMapping("/api")
public class AccidentController {

    @PostMapping("/addAccident")
    public HttpStatus registerAccident (@RequestBody AccidentProtocolDto accidentProtocolDto) {

        return HttpStatus.OK;
    }

}
