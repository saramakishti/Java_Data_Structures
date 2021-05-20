/**
 * Ervisa Lamce
 * BINF II
 * Data Structures - Lab 08
 */


import java.util.Scanner;

class Node {
    int val;
    Node left, right;

    Node(int v) {
        val = v;
        left = right = null;
    }
}

public class SumOfLeaves {

    static Node InsertNode(int v, Node top) {
        if (top == null)
            top = new Node(v);
        else if (top.val < v)
            top.right = InsertNode(v, top.right);
        else if (top.val > v)
            top.left = InsertNode(v, top.left);
        return top;
    }

    static int SumOfLeaves(Node root) {
        int sum = 0;
        if (root.left != null)
            sum += SumOfLeaves(root.left);
        if (root.right != null)
            sum += SumOfLeaves(root.right);
        if (root.left == null && root.right == null)
            sum += root.val;

        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int num;
        Node root = null;

        for (int i = 0; i < n; i++) {
            num = input.nextInt();
            root = InsertNode(num, root);
        }
        System.out.println(SumOfLeaves(root));
    }
}



