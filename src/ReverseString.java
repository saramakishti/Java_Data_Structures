import java.util.Scanner;
import java.util.Stack;

public class ReverseString {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String mySentence = input.nextLine();
        reverse(mySentence);

    }
    public static void reverse(String s)
    {
        Stack<String> stringStack = new Stack<>();
        String temp = "";
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringStack.add(temp);
                temp = "";
            } else {
                temp = temp + s.charAt(i);
            }

        }
        stringStack.add(temp);

        while(!stringStack.isEmpty())
        {
            temp = stringStack.peek();
            System.out.print(temp + " ");
            stringStack.pop();
        }

        System.out.println();
    }
}
