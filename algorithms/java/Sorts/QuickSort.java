public class QuickSort {
    public static int[] sort(int[] items, int left, int right) {
        if (items.length <= 1) {
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

    private static int partition(int[] items, int left, int right) {
        int index = (right + left) / 2;
        int pivot = items[index];

        while (left <= right) {
            while (items[left] < pivot) {
                left++;
            }

            while (items[right] > pivot) {
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

    private static int[] swap(int[] items, int i, int j) {
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;

        return items;
    }

    public static void main(String[] args) {
        int[] items = {4, 3, 2, 3, 4, 5};

        items = sort(items, 0, items.length - 1);

        printItems(items); // 2 3 3 4 4 5
    }

    public static void printItems(int[] items) {
        for (int item : items) {
            System.out.print(item + " ");
        }

        System.out.println();
    }
}
