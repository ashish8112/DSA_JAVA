package DSA.Math;
import java.util.*;

public class Armstrong_Number {
    public static void main(String args[])
    {
        double remainder=0,sum=0;
        Scanner sc= new Scanner(System.in);
        int number;
        System.out.println("Enter the number to find the Armstrong number ");
        number=sc.nextInt();
        int Armstrong_Number=number;
        int count=String.valueOf(number).length();
        while(number!=0)
        {
           remainder=number%10;
           sum=sum+Math.pow(remainder,count);
           number=number/10;

        }
        if(Armstrong_Number==sum)
        {
            System.out.println("Number is Armstrong number = "+sum);
        }
        else
            System.out.println("Number is not a Armstrong Number = "+sum);
    }

}
