package DSA.Math;

import java.util.Scanner;

public class PrintAllDivisor {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Number to find the All divisor of that Number ");
        int number=sc.nextInt();
        for(int i=1;i<=Math.sqrt(number);i++) // Every Divisor can be counted from it sqrt of number, and dividing number and quotient is also ,divisor of that number.
        {// eg: Number is 9:(Divisor,Quotient) they both are factor(divisor of Number) 9 divided by 1 so (1,9), 9 by 3 (3,3) there are only 3 divisor 1,3, and 9
            if (number % i == 0) {// eg : 16-> (Divisor,Quotient) (1,16) , (2,8), (4,4) so 1,2,4,8,16 is divisor of ,16 Notice are only dividing till its sqrt of Number.
                System.out.println(i);
                if (i != number/i)
                    //Here I can print quotient as divisor but exculding (4,4) or (3,3) because they are only one Divisor not two , bcuz one of them is prined above.
                    System.out.println(number / i);
            }
        }
    }
}
