package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern20 {
    static void pattern20(int n) //By daksh
    {
        int l=(n*2)-2;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i;j++)
            {
                System.out.print("*");
            }
            int k=2*i;
            for(int j=0;j<k;j++)
            {
                System.out.print(" ");
            }
            for(int j=0;j<n-i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<=i;k++)
            {
                System.out.print("*");
            }
            for(int k=0;k<l;k++)
            {
                System.out.print(" ");
            }
            l-=2;
            for(int k=0;k<=i;k++)
                System.out.print("*");
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
            pattern20(n);
        }
    }
}
