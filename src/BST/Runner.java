package BST;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    static Scanner in;

    public static void buildTree(BST tree) throws FileNotFoundException {
        in = new Scanner(new FileReader("src/BST/input.txt"));
        int num, n = in.nextInt();

        for (int i = 0; i < n; i++) {
            num = in.nextInt();
            tree.insert(num);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        /**Question 1 => BinarySearchTree tree1 = new BinarySearchTree();*/
        BST tree1 = new BST();

        /**Question 2 => Check if empty*/
        if (tree1.isEmpty())
            System.out.println("Tree is empty.");
        else
            System.out.println("Tree is not empty.");


        buildTree(tree1);

        if (tree1.isEmpty())
            System.out.println("Tree is empty.");
        else
            System.out.println("Tree is not empty.");


        /**Question 3 => tree1.printAllOrders();*/
        tree1.printAllOrders();

        /**Question 4 => System.out.println("\nMin value is: " + tree1.minValue());*/
        System.out.println("\nMin value is: " + tree1.minValue());

        /**Question 5 => System.out.println("\nMax value is: " + tree1.maxValue());*/
        System.out.println("\nMax value is: " + tree1.maxValue());

        /**Question 6 => System.out.println("\nThe size of the tree is: " + tree1.size());*/
        System.out.println("\nThe size of the tree is: " + tree1.size());

        /**Question 7 => Find key in tree */
        int key = 8;
        if (tree1.find(tree1.root, key))
            System.out.println("The number " + key + " is found");
        else
            System.out.println("The number " + key + " is not found");


        /**Question 8 => System.out.println("\nMax depth of the tree is: " + tree1.maxDepth());*/
        System.out.println("\nMax depth of the tree is: " + tree1.maxDepth(tree1.root));

        /**Question 9 => Check of it is BST */
        if (tree1.isBST())
            System.out.println("This is binary search tree.");
        else
            System.out.println("This is not binary search tree");


        /**Question 10 => Check if two BSTs are the same */
        BST tree2 = new BST();
        buildTree(tree2);

        if (tree1.isSameBST(tree2.root, tree1.root))
            System.out.println("They are the same.");
        else
            System.out.println("They are not the same.");

        tree2.insert(50);

        if (tree1.isSameBST(tree1.root, tree2.root))
            System.out.println("They are the same.");
        else
            System.out.println("They are not the same.");


        /**Question 11 => Delete given node in BST */
        int number = 5;
        System.out.println("Deleting..." + number);
        tree1.deleteNode(number);
        tree1.printAllOrders();


        while (!tree1.isEmpty()) {
            System.out.println("Deleting..." + tree1.minValue());
            tree1.deleteNode(tree1.minValue());
            tree1.printAllOrders();
        }

    }
}
