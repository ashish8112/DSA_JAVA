package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern19 {
    static void pattern19(int n)//take input of 10 for 10 rows
    {
        int k=1;
        for(int i=0;i<n;i++)
        {
            if(i<n/2)
            {
                for(int j=n/2-i;j>0;j--)
                {
                    System.out.print("*");
                }
                for(int j=0;j<i*2;j++)
                {
                    System.out.print(" ");
                }
                for(int j=0;j<n/2-i;j++)
                {
                    System.out.print("*");
                }
            }
            else {
                for(int j=0;j<=i-n/2;j++)
                {
                    System.out.print("*");
                }
                for(int j=1;j<=(n-(2*k));j++)
                {
                    System.out.print(" ");
                }
                for(int j=0;j<=i-n/2;j++)
                    System.out.print("*");
                k++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n;
            n=sc.nextInt();
            pattern19(n);
        }
    }
}
