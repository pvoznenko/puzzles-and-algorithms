// http://www.cs.princeton.edu/courses/archive/spring07/cos226/lectures/01union-find.pdf
class QuickUnion {
    private final int[] id;

    private QuickUnion(int n) {
        id = new int[n];

        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    int root(int p) {
        while (id[p] != p)
            p = id[p];

        return p;
    }

    boolean connected(int id1, int id2) {
        return root(id1) == root(id2);
    }

    void union(int p, int q) {
        id[root(p)] = root(q);
    }

    public static void main(String[] args) {
        int n = 10;
        QuickUnion q = new QuickUnion(n);

        q.union(3, 8);
        q.union(5, 2);
        q.union(2, 3);
        q.union(9, 1);
        q.union(7, 4);
        q.union(3, 9);

        for (int i = 0; i < n; i++)
            System.out.print(q.id[i] + " ");

        System.out.print(q.connected(3, 8) + " ");
        System.out.print(q.connected(7, 2) + " ");

        QuickUnion q1 = new QuickUnion(n);

        q1.union(8, 4);
        q1.union(5, 8);
        q1.union(3, 6);
        q1.union(1, 0);
        q1.union(7, 9);
        q1.union(9, 0);
        q1.union(3, 5);
        q1.union(3, 9);
        q1.union(6, 2);

        for (int i = 0; i < n; i++)
            System.out.print(q1.id[i] + " ");
    }
}