package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern10 {
    static void pattern10(int n)
    {
        n=n/2;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++)
                System.out.print("*");
            System.out.println();

        }

        for(int i=n;i>0;i--)
        {
            for(int j=0;j<n-i;j++)
            {
                System.out.print(" ");
            }
            for(int j=0;j<i*2-1;j++)
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
            pattern10(n);
        }
    }
}
