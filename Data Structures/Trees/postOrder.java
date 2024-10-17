public class postOrder {
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class BinaryTree {
        Node root;

        void postOrderTraversal(Node node) {
            if (node == null) {
                return;
            }

            // Traverse the left subtree
            postOrderTraversal(node.left);

            // Traverse the right subtree
            postOrderTraversal(node.right);

            // Visit the root node
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        postOrder outer = new postOrder();
        BinaryTree tree = outer.new BinaryTree();
        tree.root = outer.new Node(1);
        tree.root.left = outer.new Node(2);
        tree.root.right = outer.new Node(3);
        tree.root.left.left = outer.new Node(4);
        tree.root.left.right = outer.new Node(5);

        System.out.println("Postorder traversal of binary tree is:");
        tree.postOrderTraversal(tree.root);
    }
    
}
