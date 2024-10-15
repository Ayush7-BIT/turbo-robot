import java.util.*;

class Node implements Comparable<Node> {
    public final String value;
    public double gScores;
    public final double hScores;
    public double fScores = 0;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val, double hVal) {
        value = val;
        hScores = hVal;
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(this.fScores, other.fScores);
    }
}

class Edge {
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal) {
        target = targetNode;
        cost = costVal;
    }
}

public class AStarAlgorithm {
    public static void AStarSearch(Node source, Node goal) {
        Set<Node> explored = new HashSet<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        source.gScores = 0;
        queue.add(source);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.value.equals(goal.value)) {
                printPath(current);
                return;
            }

            explored.add(current);

            for (Edge e : current.adjacencies) {
                Node child = e.target;
                double cost = e.cost;
                double tempGScore = current.gScores + cost;
                double tempFScore = tempGScore + child.hScores;

                if ((explored.contains(child)) && (tempFScore >= child.fScores)) {
                    continue;
                } else if ((!queue.contains(child)) || (tempFScore < child.fScores)) {
                    child.parent = current;
                    child.gScores = tempGScore;
                    child.fScores = tempFScore;
                    if (queue.contains(child)) {
                        queue.remove(child);
                    }
                    queue.add(child);
                }
            }
        }
    }

    public static void printPath(Node target) {
        Node n = target;
        if (n != null) {
            printPath(n.parent);
            System.out.print(n.value + " ");
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node("A", 10);
        Node n2 = new Node("B", 8);
        Node n3 = new Node("C", 5);
        Node n4 = new Node("D", 7);
        Node n5 = new Node("E", 3);
        Node n6 = new Node("F", 6);
        Node n7 = new Node("G", 5);
        Node n8 = new Node("H", 3);
        Node n9 = new Node("I", 1);
        Node n10 = new Node("J", 0);

        n1.adjacencies = new Edge[]{new Edge(n2, 1), new Edge(n3, 4)};
        n2.adjacencies = new Edge[]{new Edge(n4, 2), new Edge(n5, 5)};
        n3.adjacencies = new Edge[]{new Edge(n6, 3)};
        n4.adjacencies = new Edge[]{new Edge(n7, 2)};
        n5.adjacencies = new Edge[]{new Edge(n8, 3)};
        n6.adjacencies = new Edge[]{new Edge(n9, 2)};
        n7.adjacencies = new Edge[]{new Edge(n10, 4)};
        n8.adjacencies = new Edge[]{new Edge(n10, 2)};
        n9.adjacencies = new Edge[]{new Edge(n10, 1)};

        AStarSearch(n1, n10);
    }
}
