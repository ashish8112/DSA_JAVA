package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern13 {
    static void pattern13(int n)
    {
        int count=1;
        for(int i= 1;i<=n;i++)
        {
            for(int j=1;j<=i;j++) {
                System.out.print(count+" ");
                count++;
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
            pattern13(n);
        }
    }
}
