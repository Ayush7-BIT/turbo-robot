class Node {
    int data;      
    Node next;
    
    Node(int data1, Node next1) {
        this.data = data1;  
        this.next = next1; 
    }
    Node(int data1) {
        this.data = data1;  
        this.next = null;  
    }
}

// array/list to linkedlist -- CREATING LINKEDLIST -- a2ll()
// print linkedlist -- TRAVERSAL -- traversalandlength()
// LENGTH of linkedlist -- traversalandlength()
// SEARCH an element in linkedlist -- search()

public class linkedlist {
    public static Node a2ll(int[] arr){
        Node head = new Node(arr[0]);
        Node mover=head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    
    public static void traversal(Node head){
        Node temp=head;
          while(temp!=null){
              System.out.print(temp.data+" ");
              temp=temp.next;
          }
          System.out.println();
    }

    public static int length(Node head){
        int length=0;
        Node temp=head;
          while(temp!=null){
              temp=temp.next;
              length++;
          }
          return length;
    }
    
    public static String search(Node head,int val){
         Node temp=head;
          while(temp!=null){
              if(temp.data==val){
                  return val+" present";
              }
              temp=temp.next;
          }
          return val+" not present";
    }

    public static Node deletehead(Node head){
        if(head==null) {
            return head;
        }
        head=head.next;
        return head;
    }

    public static Node deletetail(Node head){
        if(head==null || head.next==null) {
            return null;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }

    public static Node deletenodebyk(Node head,int k){
        if(head==null) return head;
        if(k==1) return deletehead(head);

        Node temp=head;
        Node prev=null;
        int c=0;
        while(temp!=null){
            c++;
            if(c==k){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }

    public static Node deletenodebyelmt(Node head,int k){
        if(head==null) return head;
        if(head.data==k) return deletehead(head);
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            if(temp.data==k){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }


    public static Node insertathead(Node head,int val){
        Node temp=head;
        Node a= new Node(val);
        head=a;
        a.next=temp;
        
        return head;

        //  or
        // return new Node(val,head);

    }

    public static Node insertattail(Node head,int val){
        if(head==null){
            return new Node(val,head);
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node a= new Node(val);
        temp.next=a;
        return head;

    }

    public static Node insertatk(Node head, int k,int val){
        int len=length(head);
        if(len<k){
            System.out.println("INSERTION NOT POSSIBLE (insert position > length of linked list)");
            return head;
        }
        else if(head==null){
            if(k==1) return insertathead(head, val);
            else{ System.out.println("INVALID INSERTION"); return head; }
        }
        else if(k==1) return insertathead(head, val);
        else{
            Node temp=head;
            int c=0;
            while(temp!=null){
                c++;
                if(c==k-1){
                    Node a=new Node(val);
                    a.next=temp.next;
                    temp.next=a;
                    break;
                }
                temp=temp.next;
            }
            return head;

        }
    }

    public static Node reverse(Node head) {
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            Node front =temp.next;
            temp.next = prev;  
            prev = temp;  
            temp = front; 
        }
        return prev;
    }

    // Tortoise and Hare Algorithm or Floyd’s Cycle Approach
    public static Node middle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node checkloop(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                return slow;
            }
        }
        return null;
    }

    public static int loopatindex(Node head){
        Node temp = head;
        int pos = 0;
        Node ans=checkloop(head);
        if(ans == null) return pos;
        while(temp!=ans) {
            ++pos;
            temp = temp.next;
        }
        return pos;
    }
    

    
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7, 0, 11, 69};
        
        Node head=a2ll(arr);
        traversal(head);
        
        System.out.println("length of LINkEDLIST is: " +length(head));
          
        System.out.println(search(head,8));
        System.out.println();

        // DELETE OPERATIONS
        System.out.println("_______DELETE OPERATIONS_______");
        System.out.print("deleting head: ");
        head=deletehead(head);
        traversal(head);

        System.out.print("deleting tail: ");
        head=deletetail(head);
        traversal(head);


        System.out.print("deleting 2nd elmt: ");
        head=deletenodebyk(head,2);
        traversal(head);

        System.out.print("deleting elmt '0' :");
        head=deletenodebyelmt(head,0);
        traversal(head);
        System.out.println();


        // INSERT OPERATIONS
        System.out.println("_______INSERT OPERATIONS_______");
        System.out.print("inserting at head: ");
        head=insertathead(head,69);
        traversal(head);

        System.out.print("inserting at tail: ");
        head=insertattail(head,100);
        traversal(head);

        System.out.print("inserting at 4th position: ");
        head=insertatk(head,4,82);
        traversal(head);

        System.out.println();
        System.out.print("REVERSING LL: ");
        head=reverse(head);
        traversal(head);


        // get middle node
        System.out.println();
        System.out.println("MIDDLE NODE of LL is: "+middle(head).data);

        // detecting loop 
        System.out.println();
        if(checkloop(head)==null) System.out.println("NO CYCLE/LOOP");
        else System.out.println("HAS CYCLE/LOOP");

        //loop at index
        System.out.println();
        int in=loopatindex(head);
        if(in==0) System.out.println("no cycle in LL");
        else System.out.println(in);
         
    }
}
