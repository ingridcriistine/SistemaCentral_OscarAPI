package oscar.api.sistema_central.service;

public class LoginResponse {
    private Long usuarioId;
    private Integer token;
    private String mensagem;

    public LoginResponse(Long usuarioId, Integer token, String mensagem) {
        this.usuarioId = usuarioId;
        this.token = token;
        this.mensagem = mensagem;
    }

    public Long getUsuarioId() { return usuarioId; }
    public Integer getToken() { return token; }
    public String getMensagem() { return mensagem; }
}
