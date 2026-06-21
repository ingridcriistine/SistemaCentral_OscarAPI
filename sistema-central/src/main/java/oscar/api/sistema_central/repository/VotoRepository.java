package oscar.api.sistema_central.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import oscar.api.sistema_central.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {

    boolean existsByUsuarioId(Long usuarioId);
}
