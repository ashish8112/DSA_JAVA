package DSA.Pattern_Star;

import java.util.Scanner;

public class Pattern08 {
    static void pattern08(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1)
                    System.out.print("*");
                else {
                    if (j == 0 || j == n - 1)
                        System.out.print("*");
                    else
                        System.out.print(" ");

                }
            }
            System.out.println();
        }
    }
        public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt(); // For Test Cases.
        for(int i=0;i<t;i++)
        {
            int n;
            n=sc.nextInt();
            pattern08(n);
        }
    }
}
