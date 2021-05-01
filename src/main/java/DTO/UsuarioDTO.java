
import java.time.LocalData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Incluse;

import lombok.Data;

@Data
@JsonInclude(Incluse.NON_NULL)
public class UsuarioDTO {

    @NotBlank
    private String login;

    private String senha;

    private String email;

    private String nomeCompleto;

    private String cpf;

    private String dataNascimento;

    private String numeroTelefone;

    private String saldo;
    
}