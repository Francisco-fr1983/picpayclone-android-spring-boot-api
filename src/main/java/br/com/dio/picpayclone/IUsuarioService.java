
import br.com.dio.picpayclone.modelo.Usuario;

public class IUsuarioService {

    Usuario consultarEntidade (String login);

    void validar (Usuario... usuarios);

    void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito);

    usuarioDTO consultar(String login);

    List<UsuarioDTO> listar(String login);
    
}
