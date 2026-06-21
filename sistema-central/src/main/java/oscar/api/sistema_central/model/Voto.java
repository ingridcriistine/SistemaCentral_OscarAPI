package oscar.api.sistema_central.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "votos")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long usuarioId;

    @Column(nullable = false)
    private String filmeId;

    @Column(nullable = false)
    private String diretorId;

    public Voto() {
    }

    public Voto(Long usuarioId, String filmeId, String diretorId) {
        this.usuarioId = usuarioId;
        this.filmeId = filmeId;
        this.diretorId = diretorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(String filmeId) {
        this.filmeId = filmeId;
    }

    public String getDiretorId() {
        return diretorId;
    }

    public void setDiretorId(String diretorId) {
        this.diretorId = diretorId;
    }

}
