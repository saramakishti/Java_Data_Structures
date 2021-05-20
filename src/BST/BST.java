package BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST {


    public static class Node {
        Node left;
        Node right;
        int value;

        Node(int newValue) {
            left = null;
            right = null;
            value = newValue;
        }
    }

    public Node root;


    public BST() {
        this.root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public Node insert(Node node, int newValue) {
        if (node == null) {
            node = new Node(newValue);
        } else if (newValue < node.value)
            node.left = insert(node.left, newValue);
        else if (newValue > node.value)
            node.right = insert(node.right, newValue);

        return (node);
    }

    public boolean isEmpty() {
        if (root == null) return true;
        else return false;
    }

    public static boolean isBSTChecker(Node node, int minKey, int maxKey) {
        if (node == null) {
            return true;
        }
        if (node.value < minKey || node.value > maxKey) {
            return false;
        }

        return isBSTChecker(node.left, minKey, node.value) &&
                isBSTChecker(node.right, node.value, maxKey);
    }

    public boolean isBST() {
        Node root = this.root;
        if (isBSTChecker(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return true;
        } else {
            return false;
        }
    }

    public int minValue() {
        Node current = this.root;
        while (current.left != null) {
            current = current.left;
        }
        return (current.value);
    }

    public int maxValue() {
        Node current = this.root;
        while (current.right != null)
            current = current.right;

        return (current.value);

    }

    public int size() {
        Node current = this.root;
        if (current == null)
            return 0;

        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.offer(current);

        int count = 1;
        while (!nodeQueue.isEmpty()) {
            Node tmp = nodeQueue.poll();

            if (tmp != null) {
                if (tmp.left != null) {
                    count++;
                    nodeQueue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    count++;
                    nodeQueue.offer(tmp.right);
                }
            }
        }

        return count;
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftTreeDepth = maxDepth(root.left) + 1;
        int rightTreeDepth = maxDepth(root.right) + 1;
        return Math.max(leftTreeDepth, rightTreeDepth);
    }

    public boolean find(Node root, int value) {
        boolean flag = false;

        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            if (root.value == value) {
                flag = true;
            }
            if (flag == false && root.left != null) {
                find(root.left, value);
            }
            if (flag == false && root.right != null) {
                find(root.right, value);
            }
        }
        return flag;
    }

    public boolean isSameBST(Node rootA, Node rootB) {
        if ((rootA == null) && (rootB == null)) {
            return true;
        } else if ((rootA != null && rootB == null) || (rootA == null && rootB != null)) {
            return false;
        } else if (rootA.value == rootB.value) {
            return isSameBST(rootA.left, rootB.left) && isSameBST(rootA.right, rootB.right);
        } else {
            return false;
        }
    }

    public void deleteNode(int key) {
        this.root = deleteNodeAtBST(this.root, key);
    }

    Node deleteNodeAtBST(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.value)
            root.left = deleteNodeAtBST(root.left, key);
        else if (key > root.value)
            root.right = deleteNodeAtBST(root.right, key);

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minValue();
            root.right = deleteNodeAtBST(root.right, root.value);
        }

        return root;
    }

    public void printAllOrders() {
        Node root = this.root;
        System.out.println("*******************");
        System.out.println("Pre Order Traversal");
        printPreOrder(root);

        System.out.println("-------------------");
        System.out.println("In Order Traversal");
        printInOrder(root);

        System.out.println("-------------------");
        System.out.println("Post Order Traversal");
        printPostOrder(root);

        System.out.println("-------------------");
        System.out.println("Level Order Traversal");
        printLevelOrder(root);
        System.out.println("*******************");


    }

    public void printPreOrder(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        System.out.print(root.value + " ");

        printPreOrder(root.left);

        printPreOrder(root.right);
    }

    public void printInOrder(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        printInOrder(root.left);

        System.out.print(root.value + " ");

        printInOrder(root.right);
    }

    public void printPostOrder(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        printPostOrder(root.left);

        printPostOrder(root.right);

        System.out.print(root.value + " ");
    }

    public void printLevelOrder(Node root) {

        Queue<Node> queue = new LinkedList<Node>();

        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");

            if (tempNode.left != null)
                queue.add(tempNode.left);

            if (tempNode.right != null)
                queue.add(tempNode.right);

        }
    }

}
