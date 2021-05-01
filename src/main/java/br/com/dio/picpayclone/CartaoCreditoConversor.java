
import br.com.dio.picpayclone.dto.CartaoCreditoDTO;
import br.com.dio.picpayclone.modelo.CartaoCredito;


@Component
public class CartaoCreditoConversor extends ConversorBase<CartaoCredito, CartaoCreditoDTO {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public CartaoCreditoDTO conversorEntidadeParaDto(CartaoCredito entidade) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Transacao, TransacaoDTO>(){
            @Override
            protected void configure() {

            }
        });
        return modelMapper.map(entidade, CartaoCreditoDTO.class);

    }
    @Override
    public CartaoCredito conversorDtoParaEntidade(CartaoCreditoDTO dto) {
        return CartaoCredito
               .builder()
               .bandeira(dto.getBandeira())
               .numero(CartaoCreditoUtil.mascarar(dto.getNumero()))
               .numeroToken(dto.getNumeroToken())
               .usuario(usuarioService.consultarEntidade(dto.getUsuario().getLogin()))
               .build();
    }
    
}
