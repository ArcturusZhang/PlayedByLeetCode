package arcturus.util;

public class CyclicListException extends RuntimeException {
    public CyclicListException() {
        super();
    }

    public CyclicListException(String msg) {
        super(msg);
    }

    public CyclicListException(Exception cause) {
        super(cause);
    }

    public CyclicListException(String msg, Exception cause) {
        super(msg, cause);
    }
}
