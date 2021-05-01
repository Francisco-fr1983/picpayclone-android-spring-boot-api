
import javax.validation.valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com..dio.picpayclone.dto.TransacaoDTO; 

\\Esta class será nosso RestController!!!! Nosso EndPoint

@RestController
@RequestMapping("/transacoes");
public class TransacaoResource extends ResourceBase<TransacaoDTO> {

    @Autowired
    private ITransacaoService transacaoService;


    @PostMapping
    public ResponseEntity<TransacaoDTO> salvar(@RequestBody @Valid TransacaoDTO transacaoDTO,
            UriComponentsBuilder uriBuilder) {
        TransacaoDTO transacaoRetornoDTO = transacaoService.processar(transacaoDTO);
        return responserItemCriadoComURI(transacaoRetornoDTO, UriComponentsBuilder uriBuilder, "/transacoes/{codigo}", transacaoRetornoDTO.getCodigo());


    }
    @GetMapping
    public ResponseEntity<Page<TransacaoDTO>> listar(@PageableDefault(page = 0, size = 20) Pageable paginacao, @RequestParam String login) {
        Page<TransacaoDTO> transacoes = transacaoService.listar(paginacao, login);
}       return responderListaDeItensPaginacao(transacoes);  