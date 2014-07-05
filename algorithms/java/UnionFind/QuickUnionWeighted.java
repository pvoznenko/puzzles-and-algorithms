// http://algs4.cs.princeton.edu/15uf/
// http://www.cs.princeton.edu/courses/archive/spring07/cos226/lectures/01union-find.pdf
class QuickUnionWeighted {
    private final int[] array;
    private final int[] sz;

    private QuickUnionWeighted() {
        this.array = new int[10];
        this.sz = new int[10];

        for (int i = 0; i < 10; i++) {
            this.array[i] = i;
            this.sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != this.array[i]) {
            i = this.array[i];
        }

        return i;
    }

    boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if (sz[pRoot] < sz[qRoot]) {
            array[pRoot] = array[qRoot];
            sz[qRoot] += sz[pRoot];
        } else {
            array[qRoot] = array[pRoot];
            sz[pRoot] += sz[qRoot];
        }
    }

    public static void main(String args[]) {
        QuickUnionWeighted wqu = new QuickUnionWeighted();

        wqu.union(9, 5);
        wqu.union(8, 2);
        wqu.union(8, 9);
        wqu.union(7, 4);
        wqu.union(6, 3);
        wqu.union(4, 3);
        wqu.union(4, 1);
        wqu.union(3, 2);
        wqu.union(1, 0);

        for (int i = 0; i < 10; i++)
            System.out.print(Integer.toString(wqu.array[i]) + ' ');

        System.out.print(wqu.connected(3, 8) + " ");
        System.out.print(wqu.connected(7, 2) + " ");

        System.out.print('\n');
    }
}
