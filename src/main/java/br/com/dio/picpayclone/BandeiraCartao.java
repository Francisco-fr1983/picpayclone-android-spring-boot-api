

public class BandeiraCartao {

    VISA("Visa"), MASTERCARD("Master Card"), ELO("Elo");

    private String descicao;

    BandeiraCartao(String descicao) {
        this.descicao = descicao;
    }
    public String getDescricao() {
        return descicao;
    }
    
}
