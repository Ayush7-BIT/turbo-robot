class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTree {
    TreeNode root;

    // Recursive inorder traversal
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);  // Visit left subtree
        System.out.print(node.val + " "); // Visit node
        inOrderTraversal(node.right); // Visit right subtree
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Inorder traversal:");
        tree.inOrderTraversal(tree.root); // Output: 4 2 5 1 3
    }
}
