// preOrder.java
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class preOrder {
    class BinaryTree {
        Node root;

        void preOrderTraversal(Node node) {
            if (node == null) {
                return;
            }

            // Visit the root node
            System.out.print(node.data + " ");

            // Traverse the left subtree
            preOrderTraversal(node.left);

            // Traverse the right subtree
            preOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        preOrder outer = new preOrder();
        BinaryTree tree = outer.new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is:");
        tree.preOrderTraversal(tree.root);
    }
}
