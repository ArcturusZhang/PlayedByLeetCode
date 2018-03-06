package arcturus.util;

public class WeightedQuickUnionUF implements UnionFind {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int n) {
        id = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        validate(p);
        while (p != id[p]) {
            id[p] = id[id[p]]; // 将树展平
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int p) {
        if (p < 0 || p >= id.length) throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(8);
        uf.union(0, 1);
        uf.union(0, 2);
        uf.union(6, 7);
        uf.union(4, 2);
        System.out.println(uf.connected(0, 4));
    }
}
