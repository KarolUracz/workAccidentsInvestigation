package pl.uracz.workAccident.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.uracz.workAccident.dto.AccidentRegisterDto;
import pl.uracz.workAccident.entity.AccidentRegister;
import pl.uracz.workAccident.entity.User;
import pl.uracz.workAccident.mapper.AccidentRegisterMapper;
import pl.uracz.workAccident.service.AccidentRegisterService;
import pl.uracz.workAccident.service.UserService;

import java.security.Principal;
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
}
