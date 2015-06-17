import java.util.ArrayList;
import java.util.Arrays;

class Quick {
    public static <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> items, int left, int right) {
        if (items.size() <= 1) {
            return items;
        }

        int index = partition(items, left, right);

        if (left < index - 1) {
            items = sort(items, left, index - 1);
        }

        if (index < right) {
            items = sort(items, index, right);
        }

        return items;
    }

    private static <T extends Comparable<T>> int partition(ArrayList<T> items, int left, int right) {
        int index = (right + left) / 2;
        T pivot = items.get(index);

        while (left <= right) {
            while (items.get(left).compareTo(pivot) < 0) {
                left++;
            }

            while (items.get(right).compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                items = swap(items, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static <T extends Comparable<T>> ArrayList<T> swap(ArrayList<T> items, int i, int j) {
        T tmp = items.get(i);
        items.set(i, items.get(j));
        items.set(j, tmp);

        return items;
    }
}

public class QuickSort {
    public static void main(String[] args) {
        Integer[] array = {2, 4, 5, 3, 4, 3};
        ArrayList<Integer> items = new ArrayList<>(Arrays.asList(array));

        items = Quick.sort(items, 0, items.size() - 1);

        printItems(items); // 2 3 3 4 4 5
    }

    private static <T> void printItems(ArrayList<T> items) {
        for (T item : items) {
            System.out.print(item + " ");
        }

        System.out.println();
    }
}