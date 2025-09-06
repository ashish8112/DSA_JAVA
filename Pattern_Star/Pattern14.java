package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern14 {
    static void pattern14(int n)
    {
        for(int i=0;i<n;i++)
        {
            for(char j='A';j<='A'+i;j++)
                System.out.print(j+" ");
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
            pattern14(n);
        }
    }
}
