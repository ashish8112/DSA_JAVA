package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern11 {
    static void pattern11(int n)
    {
        int start;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
                start=1;
            else
                start=0;
            for(int j=0;j<=i;j++)
            {
                System.out.print(start);
                start=1-start;
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
            pattern11(n);
        }
    }
}
