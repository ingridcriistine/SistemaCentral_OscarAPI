package oscar.api.sistema_central.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
import oscar.api.sistema_central.dto.ApiResponse;
import oscar.api.sistema_central.dto.VotoRequest;
import oscar.api.sistema_central.model.Usuario;
import oscar.api.sistema_central.model.Voto;
import oscar.api.sistema_central.repository.UsuarioRepository;
import oscar.api.sistema_central.repository.VotoRepository;

@Service
public class VotoService {

    private final UsuarioRepository usuarioRepository;
    private final VotoRepository votoRepository;

    public VotoService(UsuarioRepository usuarioRepository, VotoRepository votoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.votoRepository = votoRepository;
    }

    @Transactional
    public ApiResponse confirmarVoto(VotoRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado"));

        if (usuario.getToken() == null || !usuario.getToken().equals(request.getToken())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token invalido");
        }

        if (usuario.isJaVotou() || votoRepository.existsByUsuarioId(usuario.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ja votou");
        }

        Voto voto = new Voto(usuario.getId(), request.getFilmeId(), request.getDiretorId());
        votoRepository.save(voto);
        usuario.setJaVotou(true);
        usuarioRepository.save(usuario);

        return new ApiResponse("sucesso", "Voto registrado com sucesso");
    }
}
