
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.dio.picpayclone.enums.BandeiraCartao;
import lombok.Data;

@Data
public class CartaocreditoDTO {
    
    @NotBlank
    private BandeiraCartao bandeira;

    @NotBlank
    private String codigoSeguranca;

    @NotBlank
    private String dataExpiracao;

    @NotBlank
    private String nomeTitular;

    @NotBlank
    private String numero;

    @NotBlank
    private String numeroToken;

    @NotBlank
    private UsuarioDTO usuario;

    private Boolean isSalva = false;
}