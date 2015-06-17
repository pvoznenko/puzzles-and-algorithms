class Node<T extends Comparable<T>> {
    T val;
    Node<T> next = null;

    public Node(T val) {
        this.val = val;
    }
}

class ListNode<T extends Comparable<T>> {
    Node<T> head = null;
    int size = 0;

    public ListNode<T> add(T val) {
        if (size == 0) {
            head = new Node<>(val);
        } else {
            Node<T> node = getLastNode();
            node.next = new Node<>(val);
        }

        size++;

        return this;
    }

    public void addAll(Node<T> node) {
        Node<T> lastNode = getLastNode();
        lastNode.next = node;
        size += countNodes(node);
    }

    public Node<T> shift() {
        if (size == 0) {
            return head;
        }

        Node<T> node = head;
        head = head.next;
        node.next = null;
        size--;

        return node;
    }

    private Node<T> getLastNode() {
        Node<T> node = head;

        while (node.next != null) {
            node = node.next;
        }

        return node;
    }

    private int countNodes(Node<T> node) {
        int count = 0;

        while (node != null) {
            node = node.next;
            count++;
        }

        return count;
    }
}

class MergeSort {
    public static <T extends Comparable<T>> ListNode<T> sort(ListNode<T> list) {
        int length = list.size;

        if (length <= 1) {
            return list;
        }

        ListNode<T> left = new ListNode<>();
        ListNode<T> right = new ListNode<>();
        int middle = length / 2;

        Node<T> node;

        while (list.size > 0) {
            node = list.shift();
            ((list.size - middle) >= 0 ? left : right).add(node.val);
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private static <T extends Comparable<T>> ListNode<T> merge(ListNode<T> leftList, ListNode<T> rightList) {
        ListNode<T> result = new ListNode<>();

        if (leftList.size == 0 && rightList.size == 0) {
            return result;
        }

        Node<T> node;

        while (leftList.size > 0 && rightList.size > 0) {
            node = (rightList.head.val.compareTo(leftList.head.val) > 0 ? rightList : leftList).shift();
            result.add(node.val);
        }

        ListNode<T> listNode = (leftList.size > 0 ? leftList : rightList);
        result.addAll(listNode.head);

        return result;
    }
}

public class LinkedListMergeSort {
    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>();

        list.add(3).add(2).add(4).add(3).add(4).add(5);

        list = MergeSort.sort(list);

        printList(list.head); // 2 3 3 4 4 5
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();
    }
}
