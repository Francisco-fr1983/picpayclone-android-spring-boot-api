

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.picpayclone.modelo.Usuario;
import br.com.dio.picpayclone.repository.UsuarioRepository;
import br.com.dio.picpayclone.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
 
    @Autowired
    private UsuarioConversor usuarioConversor;

    @Override
    public Usuario consultarEntidade(String login) {
        return usuarioRepository.findByLogin(login);
    }
    @Override
    public void validar(Usuario... usuarios) {
        ArrayList.asList(usuarios).stream().forEach(usuario -> {
            if(usuario == null) {
                throw new Exception("O usuario informando não existe!")
            }
        });
    }
    @Override
    @Async("asyncExecutor")
    public void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito) {
        decrementarSaldo(transacaoSalva, isCartaoCredito);
        incrementarSaldo(transacaoSalva);

    }
    private void incrementarSaldo(Transacao transacaoSalva) {
        usuarioRepository.updateIncrementarSaldo(transacaoSalva.getDestino().getLogin(), transacaoSalva.getValor())
    }
    private void decrementarSaldo(Transacao transacaoSalva, Boolean isCartaoCredito) {
        if(!isCartaoCredito) {
            usuarioRepository.updateDecrementarSaldo(transacaoSalva.getOrigem(),getLogin(), transacaoSalva.getValor())
        }

    }
    @Override
    public UsuarioDTO consultar(String login) {
        Usuario usuario = consultarEntidade(login);
        return usuarioConversor.converterEntidadePara Dto(usuario);
    }
    @Override
    public List<UsuarioDTO> listar(String login) {
        List<Usuarios> usuarios = usuarioRepository.findAll();
        List<Usuario> ususariosFiltrados = usuarios.stream().filter(v -> !v.getLgon().equals(login))
        .collect(collects.toList());
        return usuarioConversor.converterEntidadesParaDtos(ususariosFiltrados);
    }
    
    
}
