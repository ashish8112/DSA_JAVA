package DSA.Math;

import java.util.Scanner;

public class Palindrome_Number {
    public static void main(String args[]) {

        int remainder = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number to Check Palindrome Number");
        int number = sc.nextInt();
        int palindrome=number;
        for (; number != 0; ) {
            int digit = number % 10;
            remainder = remainder * 10 + digit;
            number /= 10;
        }
        if(remainder==palindrome)
        {
            System.out.println(palindrome+" is a palindrome number ");
        }
        else
            System.out.println(palindrome+" is not a palindrome number");
    }
}
