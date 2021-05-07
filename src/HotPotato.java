import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class HotPotato {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nrOfPeople = input.nextInt();
        int nrOfPasses = input.nextInt();

        System.out.println(hotPotatoWinner(nrOfPeople, nrOfPasses));
    }

    public static int hotPotatoWinner(int n, int m) {
        Queue<Integer> myQueue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            myQueue.offer(i);

        while (myQueue.size() > 1) {
            for (int j = 1; j <= m; j++) {
                int eliminated = myQueue.remove();
                myQueue.offer(eliminated);
            }
            myQueue.remove();
        }
        return myQueue.remove();
    }
}
