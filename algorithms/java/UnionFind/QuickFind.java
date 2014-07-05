// http://www.cs.princeton.edu/courses/archive/spring07/cos226/lectures/01union-find.pdf
class QuickFind {
    private final int[] id;

    private QuickFind() {
        id = new int[10];
        for (int i = 0; i < 10; i++)
            id[i] = i;
    }

    boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    void union(int p, int q) {
        int id1 = id[p];
        int id2 = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == id1)
                id[i] = id2;
        }
    }

    public static void main(String[] args) {
        QuickFind q = new QuickFind();
        q.union(3, 8);
        q.union(5, 2);
        q.union(2, 3);
        q.union(9, 1);
        q.union(7, 4);
        q.union(3, 9);

        for (int i = 0; i < 10; i++)
            System.out.print(q.id[i] + " ");

        System.out.print(q.connected(3, 8) + " ");
        System.out.print(q.connected(7, 2) + " ");

        QuickFind q1 = new QuickFind();
        q1.union(9, 3);
        q1.union(3, 7);
        q1.union(7, 1);
        q1.union(5, 6);
        q1.union(6, 0);
        q1.union(4, 5);

        for (int i = 0; i < 10; i++)
            System.out.print(q1.id[i] + " ");
    }
}