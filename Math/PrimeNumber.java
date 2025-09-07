package DSA.Math;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
//  int count=2; //because the sqrt of 2 and 3 is smaller than 2 so loop will not execute and 2 because any number will divisible by itself and 1 so count =2.
        boolean isPrime=true;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Number to check the prime Number ");
        int number=sc.nextInt();
        for(int i=2;i<=Math.sqrt(number);i++)
        {
            if(number%i==0)
            {
//              count=count+1;
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
