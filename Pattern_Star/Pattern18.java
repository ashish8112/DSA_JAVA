package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern18 {
    static void pattern18(int n)
    {
        for(char i=(char)(64+n);i>64;i--)
        {
            for(char j=i;j<=(char)(64+n);j++)
            {
                System.out.print(j+" ");
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
            pattern18(n);
        }
    }
}
