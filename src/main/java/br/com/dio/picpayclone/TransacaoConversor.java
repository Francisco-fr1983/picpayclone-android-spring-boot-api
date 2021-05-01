
import org.springframework.stereotype.Component;

import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.modelo.Transacao;

@Conversor
public class transacaoConversor extends ConversorBase <Transacao, TransacaoDTO> {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public TransacaoDTO converterEntidadeParaDto(Transacao entidade) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertMap<Transacao, TransacaoDTO>()) {
            @Override
            protected void configure() {

            }
        }),
        return modelMapper.map(entidade, Page.class); 
    }
    @SuppressWarnings("unchecked")
    public Page<TransacaoDTO> converterPageEntidadeParaDto (Page<Transacao> entidade) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Page<Transacao>, Page<TransacaoDTO>>() {
            @Override
            protected void configure() {

            }
        });
        return modelMapper.map(entidade, Page.class);
    }
    @Override
    public Transacao converterDtoParaEntidade(TransacaoDTO dto) {
        return Transacao.builder()
                 .codigo(dto.getCodigo())
                 .dataHora(dto.getdataHora())
                 .valor(dto.getValor())
                 .destino(usuarioService.consultarEntidade(dto.getDestino().getLogin))
                 .origem(usuarioService.consultarEntidade(dto.origem().getLogin()))
                 .build();

    }
    
}
