 
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.picpayclone.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuarios")
public class UsurioResource extends ResourceBase<UsuarioDTO> {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/{login}")
    public ResponseEntity<UsuarioDTO> consultar(@PathVariable String login) {
        UsuarioDTO usuario = usuarioService.consultar(login);
        return responderSucessoComItem(usuario);
    }
    @GetMapping("/contatos")
    public ResponseEntity<List<UsuarioDTO>> listar(@RequestParam String login) {
        List<UsuarioDTO> usuarios = usuarioService.lister(login);
        return responderListaDeItens(usuarios);
    }
    @ApiOperation(value ="Consultar saldo de um usuario por login", nickname = "consultarSaldo", notes =)
            @Authorization(Value = "basiAuth") }, tags = {"usuarios"})

    @ApiResponses(value = {
            @ApiResponse(code 200, message="Saldo consultado com sucesso", response = UsuarioDTO.class),
            @ApiResponse(code 400, message="Dados informando para requisicao estao inconsistentes"),
            @ApiResponse(code 401, message="Usuario sem permissao para acessar o recurso"),
            @ApiResponse(code 404, message="Usuario não encontrado") }
    })        
    @GetMapping("/{login}/saldo")
    public ResponseEntity<UsuarioDTO> consultarSaldo(
            @PathVariable String login) {
        UsuarioDTO usuarioDTO = usuarioService.consultar(login);
        return responderSucessoComItem(usuario);
    }   



}