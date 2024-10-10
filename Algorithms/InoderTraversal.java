

class InorderTraversal {
   public static class Node {
        int data;
        Node leftNode;
        Node rightNode;
    
        public Node(int data) {
            this.data = data;
            leftNode = rightNode = null;
        }
    }
    static void InorderTraversalFunction(Node n) {
        if (n == null)
            return;
        InorderTraversalFunction(n.leftNode);
        System.out.print(n.data + " "); // Added a space for readability
        InorderTraversalFunction(n.rightNode);  // print data in inorder traversal order
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.leftNode = new Node(2);
        n.rightNode = new Node(3);
        n.leftNode.leftNode = new Node(4);
        n.leftNode.rightNode = new Node(5);
        n.rightNode.rightNode = new Node(6);
        InorderTraversalFunction(n);
    }
}
