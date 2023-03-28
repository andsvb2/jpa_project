package exceptions;

public class PersistenciaJpaException extends JpaException {

    private static final long serialVersionUID = 7159282553688713660L;

    public PersistenciaJpaException(String message) {
        super(message);
    }

    public PersistenciaJpaException(String message, Throwable cause) {
        super(message, cause);
    }
}
