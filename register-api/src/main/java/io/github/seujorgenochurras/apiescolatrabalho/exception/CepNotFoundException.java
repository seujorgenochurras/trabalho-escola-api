package io.github.seujorgenochurras.apiescolatrabalho.exception;

public class CepNotFoundException extends RuntimeException{
    public CepNotFoundException() {
    }

    public CepNotFoundException(String message) {
        super(message);
    }

    public CepNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CepNotFoundException(Throwable cause) {
        super(cause);
    }

    public CepNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
