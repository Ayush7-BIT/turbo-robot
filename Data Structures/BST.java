import java.util.Stack;
import java.util.Scanner;

class BinarySearchTree {
    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int a) {
            data = a;
            left = right = null;
        }
    }

    void Insert(int a) {
        Node nnode = new Node(a);
        if (root == null) {
            root = nnode;
        } else {
            Node temp = root;
            while (temp.left != null || temp.right != null) {
                if (nnode.data >= temp.data && temp.right != null) {
                    temp = temp.right;
                } else if (nnode.data < temp.data && temp.left != null) {
                    temp = temp.left;
                } else {
                    break;
                }
            }
            if (nnode.data >= temp.data) {
                temp.right = nnode;
            } else {
                temp.left = nnode;
            }
        }
    }

    void Inorder() {
        if (root == null) {
            System.out.println("Please Insert atleast one element in your tree.....");
        } else {
            Node temp = root;
            Stack<Node> st = new Stack<Node>();
            while (temp != null || st.size() > 0) {
                while (temp != null) {
                    st.push(temp);
                    temp = temp.left;
                }
                temp = st.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    void Preorder() {
        if (root == null) {
            System.out.println("Tree is empty...!");
        } else {
            // Node temp = root;
            Stack<Node> st1 = new Stack<Node>();
            st1.push(root);
            while (!st1.isEmpty()) {
                Node temp = st1.pop();
                System.out.print(temp.data + " ");
                if (temp.right != null) {
                    st1.push(temp.right);
                }
                if (temp.left != null) {
                    st1.push(temp.left);
                }
            }
        }
    }

    void Postorder() {
        if (root == null) {
            System.out.println("Tree is Empty.....!");
        } else {
            Stack<Node> st1 = new Stack<Node>();
            Stack<Node> st2 = new Stack<Node>();
            st1.push(root);
            while (st1.size() > 0) {
                Node temp = st1.pop();
                st2.push(temp);

                if (temp.left != null) {
                    st1.push(temp.left);
                }
                if (temp.right != null) {
                    st1.push(temp.right);
                }
            }
            while (st2.size() > 0) {
                Node temp = st2.pop();
                System.out.println(temp.data + " ");
            }

        }

    }

    void Delete(int a) {
        Node Parent;
        Node temp = root;

        while (temp != null && temp.data != a) {
            Parent = temp;

            if (a > temp.data) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }

            // Below written code is to delete the leaf node only.........
            if (temp.left == null && temp.right == null) {
                if (Parent.data > temp.data) {
                    Parent.left = null;
                } else {
                    Parent.right = null;
                }
            }

            // Below written code is to delete the parent node with only one child......
             if (temp.left == null && temp.right != null) {
                temp = temp.right;

                if (temp.data > Parent.data) { // safety condition
                    Parent.right = temp;
                } else {
                    Parent.left = temp;
                }
            }  if (temp.right == null && temp.left != null) {
                temp = temp.left;

                if (temp.data > Parent.data) {
                    Parent.left = temp;
                } else {
                    Parent.right = temp;
                }
            }
        }
            // Below written code is to delete the parent node with  two child......
            // if(temp.left==null && temp.right!=null){
            //     Node t=inorderSuccessor(temp);
            //     temp.data=t.data;
            // }
            //  inorderSuccessor(Node temp){
            //     boolean rchild=true;
            //     Node parent=temp;
            //     temp=temp.right;

            //     if(temp.left!=null){
            //         rchild=false;
            //     }
            //     while(temp.left!=null){
            //         parent=temp;
            //         temp=temp.left;
            //     }
            //     if(rchild){
            //         parent.right=temp.right;
            //     }
            //     else{
            //         parent.left=temp.right;
            //     }
            //     return temp;
            // }
    }
}

class BST {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while (true) {
            System.out
                    .println(
                            "\n(1)Insert \n(2)Display(Inorder)\n(3)Display(Preorder)\n(4)Display(Postorder)\n(5)Delete\n(6)Exit\n");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    System.out.println("Enter Numbers:");
                    int a = sc.nextInt();
                    bst.Insert(a);
                    break;

                case 2:
                    bst.Inorder();
                    break;

                case 3:
                    bst.Preorder();
                    break;

                case 4:
                    bst.Postorder();
                    break;

                case 5:
                    System.out.println("Enter Number to Delete:");
                    int d = sc.nextInt();
                    bst.Delete(d);
                    break;
                case 6:
                    System.exit(0);
                    break;

            }
        }
    }
}
