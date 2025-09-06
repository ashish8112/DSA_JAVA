package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern12 {
    static void pattern12(int n) //Give input of 4
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(j);
            for(int j=1;j<=2*n-2*i;j++)
            {
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--)
                System.out.print(j);
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
            pattern12(n);
        }
    }
}
