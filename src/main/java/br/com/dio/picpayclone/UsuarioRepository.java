
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JapRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.dio.picpayclone.modelo.Usuario;

public interface UsuarioRepository extends JapRepository<Usuario, Long>{

    Usuario findByLogin(String login);
    
    @Modifying
    @Query("update Usuario u set u.saldo = u.saldo - ?2 where u.login = ?1")
    void updateDecrementarSaldo (String login, Double valor);

    void updateIncrementarSaldo (String login, Double valor);
    
}
