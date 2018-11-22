package GraphsAndTrees;

import java.util.LinkedList;

class  Graph {
    public static int MAX_VERTICES = 6;
    private Node[] vertices;
    public int count;
    public Graph() {
        count = 0;
        vertices = new Node[MAX_VERTICES];
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void addNode(Node x){
        if(count < MAX_VERTICES) {
            vertices[count] = x;
            count++;
        }
        else {
            System.out.println("No more vertices can be added");
        }
    }
    public Node[] getNodes() {
        return vertices;
    }
}


class Node {
    Node[] adjacent;
    int adjacentCount;
    String vertex;
    FindRouteBetweenNodes.State state;
    Node(String vertex,int adjacentLength) {
        adjacentCount = 0;
        this.vertex = vertex;
        this.adjacent = new Node[adjacentLength];
    }
    Node[] getAdjacent() {
        return adjacent;
    }

    public String getVertex() {
        return vertex;
    }

    public void setAdjacent(Node[] adjacent) {
        this.adjacent = adjacent;
    }

    public void addAdjacent(Node v){
        if(adjacentCount < adjacent.length) {
            adjacent[adjacentCount] = v;
            adjacentCount++;
        }
        else {
            System.out.println("No more adjacent can be added");
        }
    }
}

public class FindRouteBetweenNodes {
    public enum State {
        unvisited, visited, visiting;
    }

    public static boolean search(Graph g, Node start, Node end) {
        LinkedList<Node> q = new LinkedList<Node>();
        for (Node u : g.getNodes()) {
            u.state = State.unvisited;
        }
        start.state = State.visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if(u!= null){
                for (Node v: u.getAdjacent()){
                    if(v.state == State.unvisited){
                        if(v == end){
                            return true;
                        } else {
                            v.state = State.visiting;
                            q.add(v);
                        }
                    }

                }
                u.state = State.visited;
            }
        }
        return false;
    }
}
