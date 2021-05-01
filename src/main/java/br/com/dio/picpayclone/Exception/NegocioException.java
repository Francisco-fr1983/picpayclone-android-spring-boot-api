

public class NegocioException extends RuntimeException {

    private static final long serialVersion = 1L;

    public NegocioException(String mensagem) {
        super(mensagem);
    }
    public NegocioException(String mensagem, Exception exception) {
        super(mensagem, exception);
    }

}