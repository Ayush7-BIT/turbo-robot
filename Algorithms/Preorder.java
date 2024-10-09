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

    // Recursive preorder traversal
    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " "); // Visit node
        preOrderTraversal(node.left);       // Visit left subtree
        preOrderTraversal(node.right);      // Visit right subtree
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Preorder traversal:");
        tree.preOrderTraversal(tree.root); // Output: 1 2 4 5 3
    }
}
