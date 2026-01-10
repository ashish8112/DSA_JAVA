package DSA.Array.Easy;
import java.util.*;
class Array_Is_Sorted {
    static boolean isSorted(int [] arr) // For ascending sorted array
    {
        int flag=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i-1]<arr[i])
            {
                flag=1;
            }
            else{
                flag=0;
            }
        }
        if(flag==0)
        return false;
        else
            return true;
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array ");
        int size;
        size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the values of the array ");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Array sorted is "+isSorted(arr));

    }
}
