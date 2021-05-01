
import io.swagger.annotation.Api;


@Api(value = "/usuarios", description = "Operacoes relarionadas a Usuarios")
public interface IUsuarioService {

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