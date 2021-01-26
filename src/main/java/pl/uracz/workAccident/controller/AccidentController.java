package pl.uracz.workAccident.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uracz.workAccident.dto.AccidentProtocolDto;
import pl.uracz.workAccident.entity.AccidentProtocol;
import pl.uracz.workAccident.mapper.AccidentProtocolMapper;
import pl.uracz.workAccident.service.AccidentProtocolService;
import pl.uracz.workAccident.service.UserService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccidentController {

    private AccidentProtocolService accidentProtocolService;
    private UserService userService;
    private AccidentProtocolMapper mapper;

    public AccidentController(AccidentProtocolService accidentProtocolService, UserService userService, AccidentProtocolMapper mapper) {
        this.accidentProtocolService = accidentProtocolService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping("/addAccident")
    public HttpStatus registerAccident (@RequestBody AccidentProtocolDto accidentProtocolDto) {
        accidentProtocolService.saveAccidentProtocol(accidentProtocolDto);
        return HttpStatus.OK;
    }

    @GetMapping("getAccident")
    public ResponseEntity<AccidentProtocolDto> getAccidentProtocol(@RequestParam String accidentNumber) {
        AccidentProtocol byProtocolNumber = accidentProtocolService.findByProtocolNumber(accidentNumber);
        if (byProtocolNumber == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AccidentProtocolDto protocolDto = mapper.dtoFromAccidentProtocol(byProtocolNumber);
        return new ResponseEntity<>(protocolDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public HttpStatus delete(@RequestParam String protocolNumber) {
        if (accidentProtocolService.deleteAccidentProtocol(protocolNumber) == 0) {
            return HttpStatus.NOT_FOUND;
        } return HttpStatus.OK;
    }

}
