package arcturus.util;

public class UnionFind {
    private int[] id;
    private int[] sz;

    public UnionFind(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public int find(int p) {
        throw new UnsupportedOperationException();
    }

    public int count() {
        throw new UnsupportedOperationException();
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // 将树展平
            i = id[i];
        }
        return i;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(8);
        uf.union(0, 1);
        uf.union(0, 2);
        uf.union(6, 7);
        uf.union(4, 2);
        System.out.println(uf.connected(0, 4));
    }
}
