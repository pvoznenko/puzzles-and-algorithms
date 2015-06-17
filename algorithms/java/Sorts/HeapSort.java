import java.util.ArrayList;

class MaxHeap<T extends Comparable<T>> {
    private ArrayList<T> items;

    public MaxHeap() {
        items = new ArrayList<>();
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public MaxHeap<T> add(T item) {
        items.add(item);
        siftUp();

        return this;
    }

    public MaxHeap<T> remove() {
        if (items.isEmpty()) {
            return this;
        }

        T lastItem = items.remove(items.size() - 1);

        if (items.isEmpty()) {
            return this;
        }

        items.set(0, lastItem);

        siftDown();

        return this;
    }

    private void siftDown() {
        int k = 0;
        int size = items.size();
        int left = 2 * k + 1;

        while (left < size) {
            int max = left;
            int right = left + 1;

            if (right < size) {
                if (items.get(right).compareTo(items.get(left)) > 0) {
                    max++;
                }
            }

            if (items.get(k).compareTo(items.get(max)) < 0) {
                T tmp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, tmp);

                k = max;
                left = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    private void siftUp() {
        int k = items.size() - 1;

        while (k > 0) {
            int p = (k - 1) / 2;

            T item = items.get(k);
            T parent = items.get(p);

            if (item.compareTo(parent) > 0) {
                items.set(k, parent);
                items.set(p, item);

                k = p;
            } else {
                break;
            }
        }
    }
}

public class HeapSort {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.add(3).add(2).add(4).add(3).add(4).add(5);

        printHeap(maxHeap.getItems()); // 5 4 4 2 3 3

        maxHeap.remove().remove().remove();

        printHeap(maxHeap.getItems()); // 3 2 3
    }

    private static <T> void printHeap(ArrayList<T> items) {

        for (T item : items) {
            System.out.print(item + " ");
        }

        System.out.println();
    }

}
