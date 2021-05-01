
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;
import org.springframework.context.MessageSource;
import org.springframework.web.bind..MethodArgumentNotValidException;
import org.springframework.web.bind..annotation.ExceptionHaldler;
import org.springframework.web.bind..annotation.ResponseStatus;
import org.springframework.web.bind..annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdiviceException {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDTO> handle(MethodArgumentNotValidException exception) {
        List<ErrorDTO> dto = new ArrayList<>();

        List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
        fieldError.stream().forEach(e -> { 
            String mensagem = messageSource.getMessage(e, LocalContextHolder.getLocate());
            ErrorDTO erro = new ErrorDTO(e.getField(), mensagem);
            dto.add(erro);

        })
        return dto;
    }

}