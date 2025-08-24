package DSA.Pattern_Star;
import java.util.*;
public class Pattern_3 {
    static void pattern01(int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0||i==n-1)
                    System.out.print("*");
                else
                {
                    if(j==0||j==n-1)
                        System.out.print("*");
                    else
                        System.out.print(" ");

                }
            }
            System.out.println();
        }
    }
    static void pattern03(int n){
        for (int i = 1; i <= n; i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(j);
            System.out.println("");
        }
    }
    static void pattern04(int n)
    {
        for (int i = 1; i <= n; i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(i);
            System.out.println("");
        }
    }
    static void pattern05(int n)
    {
        for (int i = n; i >0; i--)
        {
            for(int j=i;j>0;j--)
                System.out.print("*");
            System.out.println("");
        }
    }
    static void pattern06(int n)
    {
        for(int i=n;i>0;i--)
        {
            for(int j=i;j>0;j--)
                System.out.print((i-j+1));
            System.out.println("");
        }
    }

        static void pattern07(int n) // btw don't try this approach try next one this is good but that is best
        {
            int space =0;
           for(int i=1;i<=n;i++)
           {
               for(int j=1;j<=(n-i);j++) {
                   System.out.print(" ");
                   space=j;
               }
               for(int k=(space+1);k<=space+i*2-1;k++)
                   System.out.print("*");
               System.out.println("");
           }
        }
        static void pattern08(int n)
        {
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n - i; j++) {
                    System.out.print(" ");
                }
                    for (int j = 0; j < i * 2 + 1; j++)
                        System.out.print("*");
                System.out.println();

                }
            }

            static void pattern09(int n)
            {
                for(int i=n;i>0;i--)
                {
                    for(int j=0;j<n-i;j++)
                    {
                        System.out.print(" ");
                    }
                    for(int j=0;j<i*2-1;j++)
                        System.out.print("*");

                    System.out.println();
                }
            }

            static void pattern10(int n)
            {
                n=n/2;
                for(int i=0;i<n;i++) {
                    for (int j = 0; j < n - i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < i * 2 + 1; j++)
                        System.out.print("*");
                    System.out.println();

                }

                for(int i=n;i>0;i--)
                {
                    for(int j=0;j<n-i;j++)
                    {
                        System.out.print(" ");
                    }
                    for(int j=0;j<i*2-1;j++)
                        System.out.print("*");

                    System.out.println();
                }
            }

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

            static void pattern14(int n)
            {
                for(int i=0;i<n;i++)
                {
                    for(char j='A';j<='A'+i;j++)
                        System.out.print(j+" ");
                    System.out.println();
                }

            }

            static void pattern15(int n)
            {
                for(int i=0;i<n;i++) {
                    for (char j = 'A'; j < 'A' + (n - i); j++)
                        System.out.print(j + " ");
                    System.out.println();
                }
            }

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

            static void pattern19(int n)//take input of 10 for 10 rows
            {
                int k=1;
                for(int i=0;i<n;i++)
                {
                    if(i<n/2)
                    {
                        for(int j=n/2-i;j>0;j--)
                        {
                            System.out.print("*");
                        }
                        for(int j=0;j<i*2;j++)
                        {
                            System.out.print(" ");
                        }
                        for(int j=0;j<n/2-i;j++)
                        {
                            System.out.print("*");
                        }
                    }
                    else {
                        for(int j=0;j<=i-n/2;j++)
                        {
                            System.out.print("*");
                        }
                        for(int j=1;j<=(n-(2*k));j++)
                        {
                            System.out.print(" ");
                        }
                        for(int j=0;j<=i-n/2;j++)
                            System.out.print("*");
                        k++;
                    }
                    System.out.println();
                }
            }

            static void pattern20(int n) //By daksh
            {
                int l=(n*2)-2;
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n-i;j++)
                    {
                        System.out.print("*");
                    }
                    int k=2*i;
                    for(int j=0;j<k;j++)
                    {
                        System.out.print(" ");
                    }
                    for(int j=0;j<n-i;j++)
                    {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                for(int i=0;i<n;i++)
                {
                    for(int k=0;k<=i;k++)
                    {
                        System.out.print("*");
                    }
                    for(int k=0;k<l;k++)
                    {
                        System.out.print(" ");
                    }
                    l-=2;
                    for(int k=0;k<=i;k++)
                        System.out.print("*");
                    System.out.println();
                }

            }

            static void pattern21(int n) //Pascal Triangle
            {
                for(int i=1;i<=n;i++)
                {
                    for(int j=0;j<=n-i;j++)
                    {
                        System.out.print(" ");
                    }
                    int num=1;
                    for(int j=1;j<=i;j++)
                    {
                        System.out.print(num+" ");
                        num=num*(i-j)/j;


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
                pattern21(n);

            }


        }
    }