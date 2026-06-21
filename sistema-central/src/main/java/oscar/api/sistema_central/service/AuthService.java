package oscar.api.sistema_central.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import oscar.api.sistema_central.dto.LoginRequest;
import oscar.api.sistema_central.model.Usuario;
import oscar.api.sistema_central.repository.UsuarioRepository;

import java.util.Random;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public LoginResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByLogin(request.getLogin());

        if (usuario == null || !usuario.getSenha().equals(request.getSenha())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario ou senha invalidos");
        }

        int novoToken = new Random().nextInt(101); // 0 a 100
        usuario.setToken(novoToken);
        usuarioRepository.save(usuario);

        return new LoginResponse(usuario.getId(), novoToken, "Login realizado com sucesso");
    }
}