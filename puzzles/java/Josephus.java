
/*************************************************************************
 *  Compilation:  javac Josephus.java
 *  Execution:    java Josephus M N
 *  Dependencies: Queue.java
 *
 *  Josephus problem. In the Josephus problem from antiquity, N people are
 *  in dire straits and agree to the following strategy to reduce the population.
 *  They arrange themselves in a circle (at positions numbered from 0 to N???1) and
 *  proceed around the circle, eliminating every Mth person until only one person is
 *  left. Legend has it that Josephus figured out where to sit to avoid being eliminated.
 *
 *  Solves the Josephus problem.
 *
 *  % java Josephus 2 7
 *  1 3 5 0 4 2 6
 *
 *************************************************************************/

public class Josephus {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        // initialize the queue
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < N; i++)
            q.enqueue(i);

        while (!q.isEmpty()) {
            for (int i = 0; i < M-1; i++)
                q.enqueue(q.dequeue());
            StdOut.print(q.dequeue() + " ");
        }
        StdOut.println();
    }
}
