package oscar.api.sistema_central.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import oscar.api.sistema_central.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
}