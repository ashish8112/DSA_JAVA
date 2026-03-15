import java.util.*;

class ReverseWords {

    // Approach 1 — Using predefined methods (split + two pointers)
    public static String usingPredefined(String s) {
        String[] word = s.trim().split("\\s+");

        int left = 0;
        int right = word.length - 1;
        while (left < right) {
            String temp = word[left];
            word[left] = word[right];
            word[right] = temp;
            left++;
            right--;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            str.append(word[i]);
            if (i != word.length - 1)
                str.append(" ");
        }
        return str.toString();
    }

    // Approach 2 — Manual (right to left, no split)
    public static String manualApproach(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            String word = s.substring(i + 1, end + 1);
            if (result.length() > 0) result.append(" ");
            result.append(word);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = sc.nextLine();

        System.out.println("\n--- Approach 1: Using Predefined Methods ---");
        System.out.println("Output : \"" + usingPredefined(s) + "\"");

        System.out.println("\n--- Approach 2: Manual (Right to Left) ---");
        System.out.println("Output : \"" + manualApproach(s) + "\"");
    }
}
