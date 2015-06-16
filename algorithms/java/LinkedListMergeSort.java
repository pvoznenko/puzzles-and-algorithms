class Node {
    int val;
    Node next = null;

    public Node(int val) {
        this.val = val;
    }
}

class ListNode {
    Node head = null;
    int size = 0;

    public ListNode add(int val) {
        if (size == 0) {
            head = new Node(val);
        } else {
            Node node = getLastNode();
            node.next = new Node(val);
        }

        size++;

        return this;
    }

    public void addAll(Node node) {
        Node lastNode = getLastNode();
        lastNode.next = node;
        size += countNodes(node);
    }

    public Node shift() {
        if (size == 0) {
            return head;
        }

        Node node = head;
        head = head.next;
        node.next = null;
        size--;

        return node;
    }

    private Node getLastNode() {
        Node node = head;

        while (node.next != null) {
            node = node.next;
        }

        return node;
    }

    private int countNodes(Node node) {
        int count = 0;

        while (node != null) {
            node = node.next;
            count++;
        }

        return count;
    }
}

class MergeSort {
    public static ListNode sort(ListNode list) {
        int length = list.size;

        if (length <= 1) {
            return list;
        }

        ListNode left = new ListNode();
        ListNode right = new ListNode();
        int middle = length / 2;

        Node node;

        while (list.size > 0) {
            node = list.shift();
            ((list.size - middle) >= 0 ? left : right).add(node.val);
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private static ListNode merge(ListNode leftList, ListNode rightList) {
        ListNode result = new ListNode();

        if (leftList.size == 0 && rightList.size == 0) {
            return result;
        }

        Node node;

        while (leftList.size > 0 && rightList.size > 0) {
            node = (leftList.head.val <= rightList.head.val ? leftList : rightList).shift();
            result.add(node.val);
        }

        ListNode listNode = (leftList.size > 0 ? leftList : rightList);
        result.addAll(listNode.head);

        return result;
    }
}

public class LinkedListMergeSort {

    public static void main(String[] args) {
        ListNode list = new ListNode();

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
