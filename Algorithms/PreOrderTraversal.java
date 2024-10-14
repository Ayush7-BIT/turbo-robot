import java.io.*;
public class tree
{
    static class node
    {
        public int data;
        node left;
        node right;
        node(int val)
        {
            data=val;
        }
    }

    node root;

    public static void preorder(node root)
    {
        if(root==null)
        return;
        System.out.print(root.data+"\t");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[])
    {
        /*
         *         5
         *       /   \
         *      3     7
         *     / \   / \  
         *    2   4 6   8
         */
        // Preorder- 5   3   2   4   7   6   8
        // Inorder-  2   3   4   5   6   7   8
        // Postorder-2   4   3   6   8   7   5
        tree t=new tree();
        t.root=new node(5);
        t.root.left=new node(3);
        t.root.left.left=new node(2);
        t.root.left.right=new node(4);
        t.root.right=new node(7);
        t.root.right.left=new node(6);
        t.root.right.right=new node(8);
        System.out.println("\nPreorder :");
        preorder(t.root);
        System.out.println("\n");
    }
}
