// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
    
    // Function to reverse the linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;   // store next
            current.next = prev;   // reverse the link
            prev = current;        // move prev one step forward
            current = next;        // move current one step forward
        }
        
        return prev; // new head of the reversed list
    }
    
    // Helper function to print the linked list
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.println("Original Linked List:");
        list.printList(head);
        
        // Reverse the linked list
        ListNode reversedHead = list.reverseList(head);
        
        System.out.println("Reversed Linked List:");
        list.printList(reversedHead);
    }
}
