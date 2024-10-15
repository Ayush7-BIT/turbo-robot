class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class FastPointerSlowPointer {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; 
        }

        
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with both pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;         
            fast = fast.next.next;   

            if (slow == fast) {
                return true;          
            }
        }

        return false; 
    }

    public static void main(String[] args) {
    
        FastPointerSlowPointer solution = new FastPointerSlowPointer();

    
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; 

       
        boolean result = solution.hasCycle(node1);
        System.out.println("Cycle detected: " + result);
    }
}
