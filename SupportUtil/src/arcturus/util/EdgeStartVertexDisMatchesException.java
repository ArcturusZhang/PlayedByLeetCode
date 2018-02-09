package arcturus.util;

public class EdgeStartVertexDisMatchesException extends RuntimeException {
    public EdgeStartVertexDisMatchesException() {
        super();
    }

    public EdgeStartVertexDisMatchesException(String msg) {
        super(msg);
    }

    public EdgeStartVertexDisMatchesException(Exception cause) {
        super(cause);
    }

    public EdgeStartVertexDisMatchesException(String msg, Exception cause) {
        super(msg, cause);
    }
}
