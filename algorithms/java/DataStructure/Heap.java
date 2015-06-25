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

    public ArrayList<T> heapify(ArrayList<T> arrayList) {

        for (int i = arrayList.size() / 2; i >= 0; i--) {
            arrayList = maxHeapify(arrayList, i);
        }

        items = arrayList;

        return items;
    }

    public ArrayList<T> heapify2(ArrayList<T> arrayList) {

        int i = arrayList.size() - 1;

        while (i > 0) {
            int k = i;

            while (k > 0) {
                int p = (k - 1) / 2;

                T item = arrayList.get(k);
                T parent = arrayList.get(p);

                if (item.compareTo(parent) > 0) {
                    arrayList.set(k, parent);
                    arrayList.set(p, item);

                    k = p;
                } else {
                    break;
                }
            }

            i--;
        }

        items = arrayList;

        return items;
    }

    public ArrayList<T> maxHeapify(ArrayList<T> arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        int length = arr.size();

        if (left < length && arr.get(left).compareTo(arr.get(largest)) > 0) {
            largest = left;
        }

        if (right < length && arr.get(right).compareTo(arr.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            T temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);

            return maxHeapify(arr, largest);
        }

        return arr;
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

    public int getHeight() {
        return (int) (Math.log((double) items.size()) / Math.log(2)) + 1;
    }
}

public class HeapSort {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.add(3).add(2).add(4).add(3).add(4).add(5).add(5).add(5);

        System.out.println("Heap height is: " + maxHeap.getHeight()); // Heap height is: 4

        printHeap(maxHeap.getItems()); // 5 5 5 4 3 3 4 2

        maxHeap.remove().remove().remove();

        printHeap(maxHeap.getItems()); // 4 3 4 2 3

        ArrayList<Integer> array = new ArrayList<>();

        array.add(3);
        array.add(2);
        array.add(4);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(5);
        array.add(5);

        long startTime = System.nanoTime();
        maxHeap.heapify(array);
        long endTime = System.nanoTime();

        System.out.println();
        System.out.print("Heapify: ");

        printHeap(maxHeap.getItems());
        System.out.println("Took time: " + (endTime - startTime));

//        Heapify: 5 4 5 3 3 4 5 2
//        Took time: 22598

        startTime = System.nanoTime();
        maxHeap.heapify2(array);
        endTime = System.nanoTime();

        System.out.println();
        System.out.print("Heapify w\\ siftUp: ");
        printHeap(maxHeap.getItems());
        System.out.println("Took time: " + (endTime - startTime));

//        Heapify w\ siftUp: 5 4 5 3 3 4 5 2
//        Took time: 7496

        // I will leave two versions of Heapify since classic one is slower then just brute fors with siftUp
    }

    private static <T> void printHeap(ArrayList<T> items) {
        for (T item : items) {
            System.out.print(item + " ");
        }

        System.out.println();
    }
}
