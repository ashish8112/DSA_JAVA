package DSA.Math;
import java.util.*;
import java.lang.Math;
public class CountDIgitUsingLog10 {
    public static void main(String args[]) // time complexity = O(log n)
        {
            Scanner sc = new Scanner(System.in);
            int number;
            System.out.println("Enter the Number to count the digit ");
            number=sc.nextInt();
            number= (int)Math.log10(number)+1;
            System.out.println(number);

        }
    }


