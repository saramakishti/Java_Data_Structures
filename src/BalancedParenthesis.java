import java.util.*;

public class BalancedParenthesis {
    static boolean Opening(char c) {
        return (c == '{' || c == '(' || c == '[');
    }

    static boolean Closing(char c) {
        return (c == '}' || c == ')' || c == ']');
    }

    static char Convert(char c) {
        if (c == '(')
            return ')';
        if (c == '[')
            return ']';
        if (c == '{')
            return '}';
        return 'a';
    }

    public static void main(String[] args) {

        //Sample Input: (a + b * {c - e } ) + ( d / e
        Scanner keyboard = new Scanner(System.in);
        StringTokenizer stok = new StringTokenizer(keyboard.nextLine());

        Stack<Character> st = new Stack<>();

        boolean balanced = true;

        while (stok.hasMoreTokens() && balanced) {
            String tmp = stok.nextToken();
            char ch2;
            int len = tmp.length();
            for (int i = 0; i < len; i++) {
                char ch = tmp.charAt(i);
                if (Opening(ch)) {
                    st.push(ch);

                } else if (Closing(ch)) {
                    if (st.empty())
                        balanced = false;
                    else {
                        ch2 = st.peek();
                        st.pop();
                        ch2 = Convert(ch2);
                        if (ch != ch2)
                            balanced = false;
                    }
                }
            }

            if (!st.empty())
                balanced = false;


            if (!balanced)
                System.out.println("Not Balanced");
            else
                System.out.println("Balanced");

        }
    }
}

