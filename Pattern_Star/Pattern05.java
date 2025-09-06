package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern05 {
    static void pattern05(int n)
    {
        for (int i = n; i >0; i--)
        {
            for(int j=i;j>0;j--)
                System.out.print("*");
            System.out.println("");
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
            pattern05(n);
        }
    }
}
