import java.util.Arrays;
import java.util.Scanner;

class Node {
    int val, depth;
    Node right, left;

    Node(int v) {
        val = v;
        left = right = null;
    }
}

public class AverageDepthBST {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int number;
        int arrayOfNumbers[] = new int[1000];
        Node root = null;

        for (int i = 0; i < n; i++) {
            number = input.nextInt();
            arrayOfNumbers[i] = number;
            root = InsertNode(number, root);
        }
        int sum = totalDepth(root, 0);

        Arrays.sort(arrayOfNumbers);
        int numberOfNumbers = removeDuplicates(arrayOfNumbers);

        System.out.println("Average is " + (float) sum / numberOfNumbers);
    }

    public static int removeDuplicates(int arrayOfNumbers[]) {
        int length = arrayOfNumbers.length;
        if (length == 0 || length == 1) {
            return length;
        }

        int j = 0;

        for (int i = 0; i < length - 1; i++) {
            if (arrayOfNumbers[i] != arrayOfNumbers[i + 1])
                arrayOfNumbers[j++] = arrayOfNumbers[i];
        }
        arrayOfNumbers[j++] = arrayOfNumbers[length - 1];
        return j - 1;
    }

    static int totalDepth(Node root, int sum) {
        if (root == null)
            return 0;
        return sum + totalDepth(root.left, sum + 1) + totalDepth(root.right, sum + 1);
    }


    static Node InsertNode(int v, Node top) {
        if (top == null)
            top = new Node(v);
        else if (top.val < v)
            top.right = InsertNode(v, top.right);
        else if (top.val > v)
            top.left = InsertNode(v, top.left);
        return top;
    }
}
