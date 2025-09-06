package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern15 {
    static void pattern15(int n)
    {
        for(int i=0;i<n;i++) {
            for (char j = 'A'; j < 'A' + (n - i); j++)
                System.out.print(j + " ");
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
            pattern15(n);
        }
    }
}
