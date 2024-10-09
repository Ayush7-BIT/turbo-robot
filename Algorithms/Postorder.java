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

    // Recursive postorder traversal
    public void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);   // Visit left subtree
        postOrderTraversal(node.right);  // Visit right subtree
        System.out.print(node.val + " "); // Visit node
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Postorder traversal:");
        tree.postOrderTraversal(tree.root); // Output: 4 5 2 3 1
    }
}
