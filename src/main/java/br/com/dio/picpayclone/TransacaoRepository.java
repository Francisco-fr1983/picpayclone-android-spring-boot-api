
import java.awt.print.Pageable;
import org.springframework.data.jpa.repository.JapRepository;
import org.springframework.data.domain.Page;

import br.com.dio.picpayclone.modelo.Transacao;


public class TransacaoRepository extends JapRepository<Transacao, Long> {

    Page findByOrigem LoginOrDestino Login(String login, String login2, Pageable paginacao);
    
}
