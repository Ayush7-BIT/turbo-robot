import java.util.*;

// Class representing a point in the grid
class Node implements Comparable<Node> {
    int x, y;
    int gCost; // Distance from start node
    int hCost; // Heuristic distance to goal node
    Node parent; // Parent node to reconstruct the path

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // fCost = gCost + hCost
    public int getFCost() {
        return gCost + hCost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.getFCost(), other.getFCost());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node other = (Node) obj;
            return this.x == other.x && this.y == other.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class AStarAlgorithm {

    // Directions for moving in a grid (up, down, left, right, diagonals)
    private static final int[][] DIRECTIONS = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    // A* algorithm implementation
    public static List<Node> aStar(Node start, Node goal, int[][] grid) {
        PriorityQueue<Node> openList = new PriorityQueue<>();
        Set<Node> closedList = new HashSet<>();

        start.gCost = 0;
        start.hCost = heuristic(start, goal);
        openList.add(start);

        while (!openList.isEmpty()) {
            Node current = openList.poll();
            if (current.equals(goal)) {
                return reconstructPath(current); // Path found
            }

            closedList.add(current);

            for (int[] direction : DIRECTIONS) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                if (isValid(newX, newY, grid)) {
                    Node neighbor = new Node(newX, newY);

                    if (closedList.contains(neighbor)) {
                        continue;
                    }

                    int tentativeGCost = current.gCost + 1; // Assuming uniform cost grid
                    if (tentativeGCost < neighbor.gCost || !openList.contains(neighbor)) {
                        neighbor.gCost = tentativeGCost;
                        neighbor.hCost = heuristic(neighbor, goal);
                        neighbor.parent = current;

                        if (!openList.contains(neighbor)) {
                            openList.add(neighbor);
                        }
                    }
                }
            }
        }

        return null; // No path found
    }

    // Heuristic function: Manhattan distance
    private static int heuristic(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    // Reconstruct path from goal to start using the parent pointers
    private static List<Node> reconstructPath(Node current) {
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    // Check if the node is within grid bounds and not an obstacle (represented by 1)
    private static boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0;
    }

    // Main method to run the A* algorithm on a sample grid
    public static void main(String[] args) {
        // 0 = Free space, 1 = Obstacle
        int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        Node start = new Node(0, 0); // Starting point
        Node goal = new Node(4, 4);  // Goal point

        List<Node> path = aStar(start, goal, grid);

        if (path != null) {
            System.out.println("Path found:");
            for (Node node : path) {
                System.out.println("(" + node.x + ", " + node.y + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
