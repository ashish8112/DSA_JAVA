import java.util.*;

class RemoveOuterParentheses {

    public static String removeOuter(String s) {
        StringBuilder out = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (count > 0) out.append('(');
                count++;
            } else {
                count--;
                if (count > 0) out.append(')');
            }
        }

        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the parentheses string:");
        String s = sc.next();

        System.out.println("Input  : \"" + s + "\"");  // \" used to display " in java 
        System.out.println("Output : \"" + removeOuter(s) + "\"");
    }
}
