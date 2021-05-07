import java.util.Scanner;
import java.util.Stack;

public class PostFixExpression {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        System.out.println(evaluatePostfix(expression));
    }

    public static int evaluatePostfix(String exp) {
        Stack<Integer> integerStack = new Stack<>();
        String noSpaceExpression = exp.replaceAll("\\s", "");

        for (int i = 0; i < noSpaceExpression.length(); i++) {
            char c = noSpaceExpression.charAt(i);
            if (Character.isDigit(c)){
                integerStack.push(c - '0');
            }
            else {
                int firstNumber = integerStack.pop();
                int secondNumber = integerStack.pop();

                switch (c) {
                    case '+':
                        integerStack.push(firstNumber + secondNumber);
                        break;

                    case '-':
                        integerStack.push(secondNumber - firstNumber);
                        break;

                    case '/':
                        integerStack.push(secondNumber / firstNumber);
                        break;

                    case '*':
                        integerStack.push(firstNumber * secondNumber);
                        break;
                }
            }
        }
        return integerStack.pop();
    }
}
