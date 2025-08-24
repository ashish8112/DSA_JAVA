package DSA.Math;
import java.util.*;
public class GCD {
        public static void main(String args[])
        {
            int remainder=1;
            int a,b;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the value of a and b ");
            a=sc.nextInt();
            b=sc.nextInt();
            if(a<b)
            {
                a=a+b;
                b=a-b;
                a=a-b;
            }
            while(remainder!=0)
            {
                remainder=a%b;
                a=b;
                if(remainder==0)
                {
                    break;
                }
                b=remainder;
            }
            System.out.println("GCD of Number is "+b);

        }
    }

