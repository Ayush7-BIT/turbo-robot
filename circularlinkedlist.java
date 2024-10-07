//Circular LinkedList in Java 
class CircularLinkedList {

    // Node class representing each element in the list
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head node of the circular linked list
    private Node head = null;
    private Node tail = null;

   
    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; 
        } else {
            
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head); 
        System.out.println();
    }

    
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        Node previous = null;

       
        if (head.data == value) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail.next = head.next; 
                head = head.next; 
            }
            return;
        }
        do {
            previous = current;
            current = current.next;

            if (current.data == value) {
                previous.next = current.next;
                if (current == tail) {
                    tail = previous; 
                }
                return;
            }
        } while (current != head);

        System.out.println("Node with value " + value + " not found.");
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addNode(1);
        cll.addNode(2);
        cll.addNode(3);
        cll.addNode(4);
        cll.addNode(5);
        System.out.println("Circular Linked List: ");
        cll.display();
        cll.deleteNode(3);
        System.out.println("After deleting node 3: ");
        cll.display();
        cll.deleteNode(1);
        System.out.println("After deleting node 1: ");
        cll.display();
    }
}
