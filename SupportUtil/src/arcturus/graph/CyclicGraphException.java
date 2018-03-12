package arcturus.graph;

public class CyclicGraphException extends RuntimeException {
    public CyclicGraphException() {
        super();
    }

    public CyclicGraphException(String msg) {
        super(msg);
    }

    public CyclicGraphException(Exception cause) {
        super(cause);
    }

    public CyclicGraphException(String msg, Exception cause) {
        super(msg, cause);
    }
}
