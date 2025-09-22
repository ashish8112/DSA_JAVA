package DSA.Math;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        boolean isPrime=true;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Number to check the prime Number ");
        int number=sc.nextInt();
        for(int i=2;i<=Math.sqrt(number);i++)
        {
            if(number%i==0)
            {
                isPrime=false;
              break;
            }

            }

        if(isPrime&&number>1)
            System.out.println(number+" is a prime number");
        else
            System.out.println(number+" is not a prime number");
    }
}
