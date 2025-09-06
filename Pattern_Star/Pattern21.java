package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern21 {
    static void pattern21(int n) //Pascal Triangle
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=n-i;j++)
            {
                System.out.print(" ");
            }
            int num=1;
            for(int j=1;j<=i;j++)
            {
                System.out.print(num+" ");
                num=num*(i-j)/j;


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
            pattern21(n);
        }
    }
}
