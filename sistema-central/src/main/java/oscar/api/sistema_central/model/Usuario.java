package oscar.api.sistema_central.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    private Integer token;

    @Column(nullable = false)
    private boolean jaVotou = false;

    public Usuario() {}

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Long getId() { return id; }
    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public Integer getToken() { return token; }
    public void setToken(Integer token) { this.token = token; }
    public boolean isJaVotou() { return jaVotou; }
    public void setJaVotou(boolean jaVotou) { this.jaVotou = jaVotou; }
}