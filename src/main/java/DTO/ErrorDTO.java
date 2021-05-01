
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Incluse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(Incluse.NON_NULL)

public class ErrorDTO {

    private String campo;
    private String mensagem;
}