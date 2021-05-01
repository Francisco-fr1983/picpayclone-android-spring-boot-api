
@Component
public class UsuarioConversor extends ConversorBase<Usuario, UsuarioDTO> {

    @Override
    public UsuarioDTO conversorEntidadeParaDto(Usuario entidade) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Usuario, UsuariooDTO>(){
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(entidade, UsuarioDTO.class);
        
    }   

    
}
