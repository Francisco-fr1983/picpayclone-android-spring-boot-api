
import java.util.ArrayList;
import java.util.List;

public abstract class ConversorBase<E, D> {

    public abstract D converterEntidadeParaDTO(E entidade);

    public abstract E converterDTOParaEntidade(D dto);

    public List<D> converterEntidadesParaDTOs (List<E> entidades) {
        List<D> dtos = new ArrayList<>();
        entidades.stream().forEach(entidade -> dtos.add(converterEntidadeParaDto(entidade)));
        return dtos;
    
    }
    public List<E> converterEntidadesParaDtos(List<E> entidades) {
        List<E> entidades = new ArrayList<>();
        dtos.stream().forEach(dto -> entidades.add(converterDtoParaEntidade(dto)));
        return entidades;
    }


}