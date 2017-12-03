package arcturus.util;

public class FormatException extends RuntimeException {
    public FormatException() {
        super();
    }

    public FormatException(String msg) {
        super(msg);
    }

    public FormatException(Exception cause) {
        super(cause);
    }

    public FormatException(String msg, Exception cause) {
        super(msg, cause);
    }
}
