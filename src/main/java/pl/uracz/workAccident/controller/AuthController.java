package pl.uracz.workAccident.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.uracz.workAccident.dto.UserAuthDto;
import pl.uracz.workAccident.entity.User;
import pl.uracz.workAccident.security.jwt.JwtTokenProvider;
import pl.uracz.workAccident.service.UserService;

@RestController
public class AuthController {

    private UserService userService;
    private JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public HttpStatus registerUser (@RequestBody User user) {
        userService.saveUser(user);
        return HttpStatus.OK;
    }

    @PostMapping("/auth")
    public String auth(@RequestBody UserAuthDto userAuthDto) {
        User user = userService.findByUsernameAndPassword(userAuthDto.getUsername(), userAuthDto.getPassword());
        String token = jwtTokenProvider.generateToken(user.getUsername());
        return token;
    }
}
