
import java.awt.print.Pageable;
import org.springframework.data.domain.Page;
import br.com.dio.picpayclone.dto.TransacaoDTO;

public class ITransacaoService {

    public Transacao processar (TransacaoDTO transacaoDTO);
    Page<TransacaoDTO> listar(Pageable paginacao, String login);
    
}
