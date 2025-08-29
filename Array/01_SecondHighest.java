package DSA.Array;
import java.util.*;
// Write a program to find second largest among elements of an array
 class Second_Highest {
    static int max(int[] arr)
    {
        int max= arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])
                max=arr[i];
        }
        int s_max=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(s_max<arr[i]&& arr[i]<max)
                s_max=arr[i];
        }
        return s_max;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array ");
        int n=sc.nextInt();
        int [] arr= new int[n];
        System.out.println("Enter elements in array ");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter elements in array are as follows ");
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
        System.out.println("Second Highest Number is "+max(arr));

    }
}
