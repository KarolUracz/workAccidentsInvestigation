package pl.uracz.workAccident.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uracz.workAccident.dto.AccidentProtocolDto;
import pl.uracz.workAccident.entity.User;
import pl.uracz.workAccident.service.AccidentProtocolService;
import pl.uracz.workAccident.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccidentController {

    private AccidentProtocolService accidentProtocolService;
    private UserService userService;

    public AccidentController(AccidentProtocolService accidentProtocolService, UserService userService) {
        this.accidentProtocolService = accidentProtocolService;
        this.userService = userService;
    }

    @PostMapping("/addAccident")
    public HttpStatus registerAccident (@RequestBody AccidentProtocolDto accidentProtocolDto) {
        accidentProtocolService.saveAccidentProtocol(accidentProtocolDto);
        return HttpStatus.OK;
    }

    @GetMapping("getAccident")
    public ResponseEntity<AccidentProtocolDto> getAccidentProtocol(@RequestParam String accidentNumber) {
        AccidentProtocolDto byProtocolNumber = accidentProtocolService.findByProtocolNumber(accidentNumber);
        if (byProtocolNumber == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(byProtocolNumber, HttpStatus.OK);
    }

}
