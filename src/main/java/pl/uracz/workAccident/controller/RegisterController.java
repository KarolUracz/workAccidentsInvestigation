package pl.uracz.workAccident.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.uracz.workAccident.dto.AccidentRegisterDto;
import pl.uracz.workAccident.entity.AccidentRegister;
import pl.uracz.workAccident.entity.User;
import pl.uracz.workAccident.mapper.AccidentRegisterMapper;
import pl.uracz.workAccident.service.AccidentRegisterService;
import pl.uracz.workAccident.service.UserService;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/register")
@CrossOrigin
public class RegisterController {

    private final AccidentRegisterService accidentRegisterService;
    private final UserService userService;
    private final AccidentRegisterMapper accidentRegisterMapper;

    public RegisterController(AccidentRegisterService accidentRegisterService, UserService userService, AccidentRegisterMapper accidentRegisterMapper) {
        this.accidentRegisterService = accidentRegisterService;
        this.userService = userService;
        this.accidentRegisterMapper = accidentRegisterMapper;
    }

    @GetMapping("")
    public List<AccidentRegisterDto> getCompanyRegister (Principal principal) {
        User byUsername = userService.findByUsername(principal.getName());
        List<AccidentRegister> byCompany = accidentRegisterService.findByCompany(byUsername.getCompany());
        return accidentRegisterMapper.dtoListFromRegister(byCompany);
    }

    @PutMapping("/update")
    public HttpStatus updateRegisterEntry (@RequestParam String protocolNumber, @RequestParam String accidentPlace,
                                           @RequestParam int daysOfWorkAbsence, @RequestParam String dateOfDeliveryToZus,
                                           Principal principal) {
        User byUsername = userService.findByUsername(principal.getName());
        if (byUsername == null) {
            return HttpStatus.UNAUTHORIZED;
        }
        AccidentRegister byProtocolNumberAndCompany = accidentRegisterService.findByProtocolNumberAndCompany(protocolNumber, byUsername.getCompany());
        if (byProtocolNumberAndCompany == null) {
            return HttpStatus.NOT_FOUND;
        }
        byProtocolNumberAndCompany.setAccidentPlace(accidentPlace);
        byProtocolNumberAndCompany.setDaysOfWorkAbsence(daysOfWorkAbsence);
        byProtocolNumberAndCompany.setDateOfDeliveryToZus(LocalDate.parse(dateOfDeliveryToZus));
        accidentRegisterService.save(byProtocolNumberAndCompany);
        return HttpStatus.OK;
    }
}
