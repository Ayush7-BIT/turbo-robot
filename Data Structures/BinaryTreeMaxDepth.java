// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class BinaryTreeMaxDepth {
    // Method to find the maximum depth of a binary tree
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Recursively find the depth of left and right subtrees and take the maximum
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // Add 1 to account for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    // Main method to test the maxDepth function
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        BinaryTreeMaxDepth tree = new BinaryTreeMaxDepth();
        int depth = tree.maxDepth(root);
        System.out.println("The maximum depth of the binary tree is: " + depth);
    }
}