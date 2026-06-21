package oscar.api.sistema_central.controller;

import org.springframework.web.bind.annotation.*;

import oscar.api.sistema_central.dto.LoginRequest;
import oscar.api.sistema_central.service.AuthService;
import oscar.api.sistema_central.service.LoginResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
