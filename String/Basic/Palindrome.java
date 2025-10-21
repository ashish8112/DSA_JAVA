package DSA.String.Basic;

import java.util.*;
public class Palindrome{
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the name ");
        String name = sc.nextLine();
        name = name.toLowerCase();
        int flag=0;
        int low=0;
        int high=name.length()-1;
        while(low<high)
        {
            if(name.charAt(low)==name.charAt(high))
            {
                low++;
                high--;
            }
            else
            {
                System.out.println("This String is not palindrome ");
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("This string is a palindrome");
        }
    }
}