import java.util.LinkedList;

class Cell {
    int key;
    String val;
}

public class HashTable {
    private class LinkedListCells extends LinkedList<Cell> {
    }

    private int size;
    private LinkedList<Cell>[] list;

    public HashTable() {
        this.size = 7;
        initEmptyList();
    }

    public HashTable(int size) {
        this.size = size;
        initEmptyList();
    }

    public int getSize() {
        return size;
    }

    public LinkedList<Cell>[] getList() {
        return list;
    }

    public HashTable add(String item) {
        int hash = getHash(item);
        int index = hash % size;
        Cell cell = new Cell();
        cell.key = hash;
        cell.val = item;

        if (list[index] == null) {
            list[index] = new LinkedListCells();
        }

        LinkedList<Cell> cellList = list[index];

        if (!cellList.isEmpty()) {
            for (Cell existingCell : cellList) {
                if (existingCell.key != hash) {
                    continue;
                }

                System.out.println("Cell with String '" + item + "' already exist!");
                return this;
            }
        }

        cellList.add(cell);

        list[index] = cellList;

        return this;
    }

    public String get(String item) {
        int hash = getHash(item);
        int index = hash % size;

        LinkedList<Cell> cellList = list[index];

        if (cellList == null) {
            System.out.println("Cell with String'" + item + "' not found!");
            return "";
        }

        for (Cell cell : cellList) {
            if (cell.key != hash) {
                continue;
            }

            return cell.val;
        }

        System.out.println("Cell with String'" + item + "' not found!");

        return "";
    }

    private void initEmptyList() {
        list = new LinkedListCells[size];
    }

    private int getHash(String item) {
        int charSum = 0;

        for (int i = 0; i < item.length(); i++) {
            charSum += (int) item.charAt(i) << i;
        }

        return charSum;
    }
}

class HashTableRun {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.add("first").add("second").add("third")
                .add("second") // Cell with String 'second' already exist!
                .add("ifrst");

        printHashTable(hashTable); // [1: {3256: 'third', }, 2: {3544: 'first', 6561: 'second', }, 6: {3541: 'ifrst', }, ]

        String val = hashTable.get("third"); // "third"
    }

    private static void printHashTable(HashTable hashTable) {
        LinkedList<Cell>[] list = hashTable.getList();

        System.out.print("[");
        for (int i = 0; i < hashTable.getSize(); i++) {
            if (list[i] == null) {
                continue;
            }

            System.out.print(i + ": {");

            for (Cell cell : list[i]) {
                System.out.print(cell.key + ": '" + cell.val + "', ");
            }

            System.out.print("}, ");
        }

        System.out.print("]");
        System.out.println();
    }
}
