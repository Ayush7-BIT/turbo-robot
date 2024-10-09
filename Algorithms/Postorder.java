class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTree {
    // Postorder traversal using recursion
    public void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // Traverse the left subtree
        postorderTraversal(root.left);
        // Traverse the right subtree
        postorderTraversal(root.right);
        // Visit the root
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTree tree = new BinaryTree();
        System.out.print("Postorder Traversal: ");
        tree.postorderTraversal(root);
    }
}
