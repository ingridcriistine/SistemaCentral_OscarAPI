package oscar.api.sistema_central.dto;

public class ApiResponse {

    private String status;
    private String mensagem;

    public ApiResponse(String status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
