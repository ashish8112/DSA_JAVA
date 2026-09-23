package DSA.Recursion;

import java.util.Scanner;

public class recursion_basic{
    public  static int factorial(int x)
    {
        if(x==1||x==0)
            return 1;

            return x*factorial(x-1);


    }
    public static void main(String args[])
    {
        int number;
        System.out.println("Enter the Number");
        Scanner obj=new Scanner(System.in);
        number=obj.nextInt();
        int fact;
        fact=factorial(number);
        System.out.println("Factorial = "+fact);

    }
}
