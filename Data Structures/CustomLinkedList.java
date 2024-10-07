// => Implement a program to create a node for singly linked list. Read the data in a node, print the node.
// => Write a menu driven program to implement following operations on the singly linked list.
// a. Insert a node at the front of the linked list.
// b. Display all nodes.
// c. Delete a first node of the linked list.
// d. Insert a node at the end of the linked list. 
// e. Delete a last node of the linked list. 
// f. Delete a node from specified position. 

import java.util.Scanner;

public class CustomLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void addFirst(int a) {
        Node node = new Node(a);
        node.next = head;
        head = node;
    }

    public void addLast(int a) {
        Node node = new Node(a);
        if (head == null) {
            head = node;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;

    }

    public void insertByIndex(int index, int a) {
        if (index == 0) {
            addFirst(a);
            return;
        }
        int count = 0;
        Node node = new Node(a);
        Node currentNode = head, prev = null;
        while (count != index && currentNode != null) {
            prev = currentNode;
            currentNode = currentNode.next;
            count++;
        }
        if (currentNode == null) {
            System.out.println("Index out of bounds ");
            return;
        }
        prev.next = node;
        node.next = currentNode;
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("List is Empty \nCannot Remove an item from an empty list");
            return -1;
        }
        int element = head.data;
        head = head.next;
        return element;
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("List is Empty \nCannot Remove an item from an empty list");
            return -1;
        }
        Node currentnode = head, prev = null;
        int element = -1;
        while (currentnode.next != null) {
            prev = currentnode;
            currentnode = currentnode.next;
            element = currentnode.data;
        }
        if (currentnode == head) {
            head = null;
            return currentnode.data;
        }
        prev.next = null;
        return element;
    }

    public void deleteByData(int value) {
        if (head == null) {
            System.out.println("List is Empty \nCannot Remove an item from an empty list");
        } else if (head.data == value) {
            head = head.next;
        } else {
            Node prev = null, currentNode = head;
            while (currentNode != null && currentNode.data != value) {
                prev = currentNode;
                currentNode = currentNode.next;
            }
            if (currentNode != null) {
                prev.next = currentNode.next;
            } else {
                System.out.println("List does not contain [" + value + "]");
            }
        }
    }

    public int deleteByIndex(int i) {
        Node prev = null, currentNode = head;
        int count = 0, element = -1;
        if (head == null) {
            System.out.println("List is Empty \nCannot Remove an item from an empty list");
            return -1;
        } else if (i == 0) {
            return removeFirst();
        }
        while (currentNode.next != null && count != i) {
            prev = currentNode;
            currentNode = currentNode.next;
            element = currentNode.data;
            count++;
        }
        if (count == i && currentNode != null) {
            prev.next = currentNode.next;
            return element;
        } else {
            System.out.println("Index out of bounds");
            return -1;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print("[" + currentNode.data + "] ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        Scanner sc = new Scanner(System.in);
        String str = "Press 1 to insert a node at the front of the linked list.\nPress 2 to display all nodes.\nPress 3 to delete a first node of the linked list.\nPress 4 to insert a node at the end of the linked list.\nPress 5 to delete a last node of the linked list.\nPress 6 to delete a node from specified position. \nPress 7 to delete a node by its value\nPress 8 to insert an element by index\nPress 9 to exit";
        System.out.println(str);
        int choice = sc.nextInt();
        while (true) {
            if (choice == 1) {
                System.out.println("Enter the element");
                list.addFirst(sc.nextInt());
                System.out.println(str);
                choice = sc.nextInt();
            } else if (choice == 2) {
                list.display();
                System.out.println(str);
                choice = sc.nextInt();
            } else if (choice == 3) {
                System.out.println("Deleted Element : [" + list.removeFirst() + "]");
                System.out.println(str);
                choice = sc.nextInt();
            } else if (choice == 4) {
                System.out.println("Enter the element");
                list.addLast(sc.nextInt());
                System.out.println(str);
                choice = sc.nextInt();
            } else if (choice == 5) {
                System.out.println("Deleted Element : [" + list.removeLast() + "]");
                System.out.println(str);
                choice = sc.nextInt();
            } else if (choice == 6) {
                System.out.println("Enter the index of the node that you want to delete");
                System.out.println("Deleted Element : [" + list.deleteByIndex(sc.nextInt()) + "]");
                System.out.println(str);
                choice = sc.nextInt();
            } else if (choice == 7) {
                System.out.println("Enter the value of the node that you want to delete");
                list.deleteByData(sc.nextInt());
                System.out.println(str);
                choice = sc.nextInt();
            } else if (choice == 8) {
                System.out.println("Enter index");
                int i = sc.nextInt();
                System.out.println("Enter element");
                list.insertByIndex(i, sc.nextInt());
                System.out.println(str);
                choice = sc.nextInt();
            } else {
                break;
            }
        }
        sc.close();
    }
}
