import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = next = null;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void insert(Node node) {
        // map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void remove(Node node) {
        // map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            remove(temp);
            insert(temp);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node temp = new Node(key, value);
            map.put(key, temp);
            insert(temp);
        }
    }

    public int get(int key) {
        int x;
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
            insert(temp);
            x = temp.value;
        } else {
            return -1;
        }
        return x;
    }
}
