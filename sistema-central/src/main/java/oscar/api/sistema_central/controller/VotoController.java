package oscar.api.sistema_central.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oscar.api.sistema_central.dto.ApiResponse;
import oscar.api.sistema_central.dto.VotoRequest;
import oscar.api.sistema_central.service.VotoService;

@RestController
@RequestMapping("/votos")
public class VotoController {

    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping("/confirmar")
    public ApiResponse confirmar(@RequestBody VotoRequest request) {
        return votoService.confirmarVoto(request);
    }
}
