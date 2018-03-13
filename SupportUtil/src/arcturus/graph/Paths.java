package arcturus.graph;

import java.util.List;

public interface Paths {
    boolean hasPathTo(int v);
    List<Integer> pathTo(int v);
}
