package DSA.Math;
import java.util.*;

public class Reverse_Integer {
    public static void main(String args[]) {

        int remainder = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number to reverse ");
        int number = sc.nextInt();
        while (number != 0) {
            int digit = number % 10;
            remainder = remainder * 10 + digit;
            number /= 10;
        }
        System.out.println("Reverse Number = " + remainder);
    }
}
