import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StacksAndQueues {

    public static void main(String[] args) {

        Stack<Integer> myFirstStack = new Stack<>();
        Stack<Integer> mySecondStack = new Stack<>();

        Queue<Integer> myQueue = new ArrayDeque<>();


        int arrayOfNumbers[] = {-1, 15, 23, 44, 4, 99};
        int k = 23;

        //Fill Stack with Numbers
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            myFirstStack.push(arrayOfNumbers[i]);
        }

        //Fill the other stack and the queue
        while (!myFirstStack.isEmpty()) {
            int eliminated = myFirstStack.pop();
            mySecondStack.push(eliminated);
            myQueue.offer(eliminated);
        }

    }

}
