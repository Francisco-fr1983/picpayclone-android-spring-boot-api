
import java.time.LocalDataTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Incluse;

import lombok.Data;

@Data
@JsonInclude(Incluse.NON_NULL)
public class TransacaoDTO {
    
    NotBlank
    private String codigo;

    @NotNull
    private UsuarioDTO origem;

    @NotNull
    private UsuarioDTO destino;

    @NotNull
    private LocalDataTime dataHora;

    @NotNull
    private Double valor;

    private CartaocreditoDTO cartaoCredito;

    private Boolean isCartaoCredito = false;

}