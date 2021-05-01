
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.modelo.Transacao;
import br.com.dio.picpayclone.service.ITransacaoService;

@Service
public class transacaoService implements ITransacaoService {
    
    @Autowired
    private transacaoConversor transacaoConversor;
    @Autowired
    private IUsuarioService usuarioService;
    
    @Autowired
    private TransacaoRepository transacaoRepository;
    
    @Autowired 
    private ICartaoCreditoService cartaoCreditoService;

    @Override
    public TransacaoDTO processar(TransacaoDTO transacaoDTO) {
        Transacao transacao = salvar(transacaoDTO);
        cartaoCreditoService.salvar(transacaoDTO.getCartaoCredito());
        usuarioService.atualizarSaldo(transacao, transacaoDTO.getCartaoCredito());
        return transacaoConversor.converterEntidadeParaDTO(transacao);
    }
    private Transacao salvar(TransacaoDTO transacaoDTO) {
        Transacao transacao = transacaoConversor.cnverterDTOParaEntidade(transacaoDTO);
        usuarioService.validar(transacao.getDestino(), transacao.getOrigem());
        return transacaoRepository.save(transacao);
        
    }
    @Override
    public Page<TransacaoDTO> listar(Pageable paginacao, String login);
        Page<Transacao> Transacoes = transacaoRepository.findByOrigem_LoginOrDestino_Login(login, login, paginacao);
        return transacaoConversor.converterPageEntidadeParaDto(transacoes);

}