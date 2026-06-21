package oscar.api.sistema_central.dto;

public class VotoRequest {

    private Long usuarioId;
    private String filmeId;
    private String diretorId;
    private Integer token;

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

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

}
