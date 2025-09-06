package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern17 {
    static void pattern17(int n)
    {
        char l=64;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n-i;j++)
            {
                System.out.print("  ");
            }
            for(int k=1;k<=2*i-1;k++)
            {
                if(k<=i)
                {
                    l++;
                    System.out.print(l+" ");

                }
                else{

                    System.out.print(--l+" ");
                }
            }
            l='@';
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
            pattern17(n);
        }
    }
}
