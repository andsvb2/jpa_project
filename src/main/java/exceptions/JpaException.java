package exceptions;

public class JpaException extends Exception {
        private static final long serialVersionUID = -7669751088704144947L;

        public JpaException(String message) {
            super(message);
        }

        public JpaException(String message, Throwable cause) {
            super(message, cause);
        }
}
