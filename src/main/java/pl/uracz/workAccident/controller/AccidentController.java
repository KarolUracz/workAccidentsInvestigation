package pl.uracz.workAccident.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uracz.workAccident.dto.AccidentProtocolDto;
import pl.uracz.workAccident.entity.AccidentProtocol;
import pl.uracz.workAccident.entity.User;
import pl.uracz.workAccident.mapper.AccidentProtocolMapper;
import pl.uracz.workAccident.service.AccidentProtocolService;
import pl.uracz.workAccident.service.UserService;

import javax.validation.Valid;
import java.security.Principal;


@RestController
@RequestMapping("/api/accident")
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
    public HttpStatus registerAccident (@Valid @RequestBody AccidentProtocolDto accidentProtocolDto, Principal principal) {
        if (principal == null) {
            return HttpStatus.UNAUTHORIZED;
        }
        User byUsername = userService.findByUsername(principal.getName());
        accidentProtocolService.saveAccidentProtocol(accidentProtocolDto, byUsername);
        return HttpStatus.OK;
    }

    @GetMapping("getAccident")
    public ResponseEntity<AccidentProtocolDto> getAccidentProtocol(@RequestParam String accidentNumber, Principal principal) {
        AccidentProtocol byProtocolNumber = accidentProtocolService.findByProtocolNumber(accidentNumber);
        User byUsername = userService.findByUsername(principal.getName());
        if (!byProtocolNumber.getUser().equals(byUsername)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (byProtocolNumber == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AccidentProtocolDto protocolDto = mapper.dtoFromAccidentProtocol(byProtocolNumber);
        return new ResponseEntity<>(protocolDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public HttpStatus delete(@RequestParam String protocolNumber, Principal principal) {
        User byUsername = userService.findByUsername(principal.getName());
        AccidentProtocol byProtocolNumber = accidentProtocolService.findByProtocolNumber(protocolNumber);
        if (byProtocolNumber.getUser() != byUsername) {
            return HttpStatus.UNAUTHORIZED;
        }
        if (accidentProtocolService.deleteAccidentProtocol(protocolNumber) == 0) {
            return HttpStatus.NOT_FOUND;
        } return HttpStatus.OK;
    }

    @PutMapping("/update")
    public HttpStatus updateProtocol (@RequestBody AccidentProtocol accidentProtocol, Principal principal) {
        User byUsername = userService.findByUsername(principal.getName());
        if (byUsername == null) {
            return HttpStatus.UNAUTHORIZED;
        }
        AccidentProtocol byId = accidentProtocolService.findById(accidentProtocol.getId());
        if (byUsername.equals(byId.getUser())) {
            accidentProtocol.setUser(byUsername);
            accidentProtocolService.updateAccident(accidentProtocol);
            return HttpStatus.OK;
        }
        return HttpStatus.NO_CONTENT;
    }

    @GetMapping("/update")
    public ResponseEntity<AccidentProtocol> updateAccidentProtocol(@RequestParam String accidentNumber, Principal principal) {
        AccidentProtocol byProtocolNumber = accidentProtocolService.findByProtocolNumber(accidentNumber);
        User byUsername = userService.findByUsername(principal.getName());
        if (!byProtocolNumber.getUser().equals(byUsername)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (byProtocolNumber == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        byProtocolNumber.setUser(null);
        return new ResponseEntity<>(byProtocolNumber, HttpStatus.OK);
    }

    @GetMapping("/finish")
    public HttpStatus finishProtocol (@RequestParam String protocolNumber, Principal principal) {
        User byUsername = userService.findByUsername(principal.getName());
        if (byUsername == null) {
            return HttpStatus.UNAUTHORIZED;
        }
        AccidentProtocol byProtocolNumber = accidentProtocolService.findByProtocolNumber(protocolNumber);
        if (!byProtocolNumber.getUser().equals(byUsername)) {
            return HttpStatus.UNAUTHORIZED;
        }
        if (byProtocolNumber == null) {
            return HttpStatus.NOT_FOUND;
        }
        accidentProtocolService.finishProtocol(byProtocolNumber, byUsername);
        return HttpStatus.OK;
    }
}
