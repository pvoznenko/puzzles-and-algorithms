import java.util.*;

public class Graph {
    private class LinkedListNodes extends LinkedList<Edge> {
        public boolean hasNode(Node node) {
            for (Edge edge : this) {
                if (edge.node != node) {
                    continue;
                }

                return true;
            }

            return false;
        }
    }

    private class Node {
        int vertex;

        Node(int vertex) {
            this.vertex = vertex;
        }
    }

    private class Edge {
        Node node;
        int weight;

        Edge(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private class NodeAdjacency {
        Node node;
        LinkedListNodes list;

        NodeAdjacency(Node node) {
            this.node = node;
            list = new LinkedListNodes();
        }
    }

    Map<Integer, NodeAdjacency> adjacencyList = new HashMap<>();

    public boolean addVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return false;
        }

        Node node = new Node(vertex);
        NodeAdjacency adjacency = new NodeAdjacency(node);

        adjacencyList.put(vertex, adjacency);

        return true;
    }

    public boolean addEdge(int fromVertex, int toVertex, int weight) {
        if (!adjacencyList.containsKey(fromVertex) || !adjacencyList.containsKey(toVertex)) {
            return false;
        }

        NodeAdjacency nodeAdjacency = adjacencyList.get(fromVertex);
        LinkedListNodes adjacency = nodeAdjacency.list;

        NodeAdjacency toNodeAdjacency = adjacencyList.get(toVertex);
        Node toNode = toNodeAdjacency.node;

        if (adjacency.hasNode(toNode)) {
            return false;
        }

        Edge edge = new Edge(toNodeAdjacency.node, weight);

        adjacency.add(edge);
        nodeAdjacency.list = adjacency;

        adjacencyList.replace(fromVertex, nodeAdjacency);

        return true;
    }

    public List<Integer> runBFS(int startVertex) {
        List<Integer> data = new LinkedList<>();

        if (!adjacencyList.containsKey(startVertex)) {
            return data;
        }

        Queue<Integer> queue = new LinkedList<>();

        data.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            NodeAdjacency nodeAdjacency = adjacencyList.get(vertex);
            LinkedListNodes edges = nodeAdjacency.list;

            if (edges.isEmpty()) {
                continue;
            }

            for (Edge edge : edges) {
                int neighborVertex = edge.node.vertex;

                if (data.contains(neighborVertex)) {
                    continue;
                }

                queue.add(neighborVertex);
                data.add(neighborVertex);
            }
        }

        return data;
    }

    public List<Integer> runDFS(int startVertex) {
        List<Integer> data = new LinkedList<>();

        if (!adjacencyList.containsKey(startVertex)) {
            return data;
        }

        Stack<Integer> stack = new Stack<>();

        data.add(startVertex);
        stack.add(startVertex);

        data = DFS(startVertex, data, stack);

        return data;
    }

    private List<Integer> DFS(int vertex, List<Integer> data, Stack<Integer> stack) {
        NodeAdjacency nodeAdjacency = adjacencyList.get(vertex);
        LinkedListNodes edges = nodeAdjacency.list;
        boolean noNewVertexLeft = true;

        for (Edge edge : edges) {
            int neighborVertex = edge.node.vertex;

            if (data.contains(neighborVertex)) {
                continue;
            }

            stack.add(neighborVertex);
            data.add(neighborVertex);

            data = DFS(neighborVertex, data, stack);
            noNewVertexLeft = false;
        }

        if (noNewVertexLeft && !stack.isEmpty() && stack.size() > 1) {
            stack.pop();
            int prevVertex = stack.pop();

            data = DFS(prevVertex, data, stack);
        }

        return data;
    }
}

class RunGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(1, 2, 12);
        graph.addEdge(1, 3, 10);
        graph.addEdge(1, 4, 16);
        graph.addEdge(2, 5, 18);
        graph.addEdge(3, 4, 13);
        graph.addEdge(5, 1, 14);

//        1 -> 2 (12), 3 (10), 4 (16)
//        2 -> 5 (18)
//        3 -> 4 (13)
//        4
//        5 -> 1 (14)

        int[] paths = {1, 2, 3, 4, 5};
        List<Integer> path;

        for (int p : paths) {
            System.out.print("BFS path for vertex " + p + ": ");
            path = graph.runBFS(p);
            printPath(path);
        }

//        BFS path for vertex 1: 1 2 3 4 5
//        BFS path for vertex 2: 2 5 1 3 4
//        BFS path for vertex 3: 3 4
//        BFS path for vertex 4: 4
//        BFS path for vertex 5: 5 1 2 3 4

        System.out.println();

        for (int p : paths) {
            System.out.print("DFS path for vertex " + p + ": ");
            path = graph.runDFS(p);
            printPath(path);
        }

//        DFS path for vertex 1: 1 2 5 3 4
//        DFS path for vertex 2: 2 5 1 3 4
//        DFS path for vertex 3: 3 4
//        DFS path for vertex 4: 4
//        DFS path for vertex 5: 5 1 2 3 4
    }

    private static void printPath(List<Integer> path) {
        for (int p : path) {
            System.out.print(p + " ");
        }

        System.out.println();
    }
}
