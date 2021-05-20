///**
// * Ervisa Lamce
// * BINF II
// * Data Structures - Lab 08
// */
//
//
//import java.util.Scanner;
//
//class Node {
//    int val, depth;
//    Node right, left;
//
//    Node(int v, int d) {
//        val = v;
//        depth = d;
//        left = right = null;
//    }
//}
//
//public class DepthLimitedBST {
//
//    static int n, limit;
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        n = input.nextInt();
//        limit = input.nextInt();
//
//        Node T = null;
//
//        int num;
//
//        for (int i = 0; i < n; i++) {
//            num = input.nextInt();
//            T = InsertNode(num, 0, T);
//        }
//        num = input.nextInt();
//
//        Node res = FindNode(num, T);
//        if (res == null)
//            System.out.println(-1);
//        else
//            System.out.println(res.depth);
//    }
//
//    static Node InsertNode(int v, int d, Node T) {
//        if (d > limit) return null;
//        if (T == null)
//            T = new Node(v, d);
//        else if (T.val < v)
//            T.right = InsertNode(v, d + 1, T.right);
//        else if (T.val > v)
//            T.left = InsertNode(v, d + 1, T.left);
//
//        return T;
//    }
//
//    static Node FindNode(int v, Node T) {
//        if (T == null) return null;
//        if (T.val > v) return FindNode(v, T.left);
//        if (T.val < v) return FindNode(v, T.right);
//        return T;
//    }
//}
//
