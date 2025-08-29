package DSA.Searching;
import java.util.*;

public class Binary_Search {
   public static int binary_search(int []arr,int target)
    {
        int start_ptr=0;
        int end_ptr=arr.length-1;
        int mid;
        while(start_ptr<=end_ptr) // we use mid -1 or mid +1 because if we use high=mid or low=mid sometime it will create infinite loop like take arr of sz 5 and search element of 4th index or last .
        {
            mid=(start_ptr+end_ptr)/2;
            if(target==arr[mid]) {
                return mid;
            }
            else if(arr[mid]<target)
            {
                start_ptr=++mid;
            }
            else if(arr[mid]>target)
            {
                end_ptr=--mid;
            }
        }
        return -1;
    }

    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int n ;
        System.out.println("Enter the size of array ");
        n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter the array in sorted manner ");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the target value to check it's index ");
        int target=sc.nextInt();
        int value=binary_search(arr,target);
        if(value==-1)
            System.out.println("Target is not present in array");
        else
            System.out.println("Target is at "+(value+1));

    }
}
