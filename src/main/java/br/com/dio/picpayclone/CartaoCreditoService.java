
import br.com.dio.picpayclone.service.ICartaoCreditoService;
import br.com.dio.picpayclone.modelo.CartaoCredito;
import br.com.dio.picpayclone.dto.CartaoCreditoDTO;

@Service
public class cartaoCreditoService implements ICartaoCreditoService {

    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    private CartaoCreditoConversor cartaoCreditoConversor;

    @Autowired
    private IUsuarioService usuarioService;    

    @Override
    public CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCreditoDTO cartaoCreditoRetorno = null;
        if (cartaoCreditoDTO.getIsSalva()) {
            CartaoCredito cartaoCredito = cartaoCreditoConversor.conversorDtoParaEntidade(cartaoCreditoDTO);
            usuarioService.validar(cartaoCreditoConversor.getUsuario());
            CartaoCredito cartaoCreditoSalvo = cartaoCreditoRepository.save(cartaoCredito);
            cartaoCreditoRetorno = cartaoCreditoConversor.converterEntidadeParaDto(cartaoCreditoSalvo);
        }
        return cartaoCreditoRetorno;
    }
    
}
