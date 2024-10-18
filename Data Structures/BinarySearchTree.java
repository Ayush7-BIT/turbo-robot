class TreeNode {
    int data;
    TreeNode leftChild, rightChild;

    public TreeNode(int value) {
        data = value;
        leftChild = rightChild = null;
    }
}

class BinaryTree {
    TreeNode root;

    void insert(int value) {
        root = insertRecursively(root, value);
    }

    TreeNode insertRecursively(TreeNode currentNode, int value) {
        if (currentNode == null) {
            return new TreeNode(value);
        }
        if (value < currentNode.data) {
            currentNode.leftChild = insertRecursively(currentNode.leftChild, value);
        } else if (value > currentNode.data) {
            currentNode.rightChild = insertRecursively(currentNode.rightChild, value);
        }
        return currentNode;
    }

    void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.leftChild);
            System.out.print(node.data + " ");
            inOrderTraversal(node.rightChild);
        }
    }
}
