package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern16 {
    static void pattern16(int n)
    {
        int k=0;
        for (char i='A';i<='A'+(n-1);i++)
        {
            for(char j='A';j<='A'+k;j++)
            {
                System.out.print(i);
            }
            k++;
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
            pattern16(n);
        }
    }
}
