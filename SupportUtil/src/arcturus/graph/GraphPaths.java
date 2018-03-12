package arcturus.graph;

import java.util.List;

public interface GraphPaths {
    boolean hasPathTo(int v);
    List<Integer> pathTo(int v);
}
