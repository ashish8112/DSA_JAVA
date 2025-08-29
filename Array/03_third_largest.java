package DSA.Array;
import java.util.*;
class third_largest {
    static void third_largest(int [] arr)
    {
       int max,s_max,t_max;
       max=Integer.MIN_VALUE;
       s_max=Integer.MIN_VALUE;
       t_max=Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++)
        {
            if (arr[i] > max) {
                t_max=s_max;
                s_max=max;
                max=arr[i];
            }
            else if(arr[i]>s_max&&arr[i]<max)
            {
                s_max=arr[i];
            }
            else if(arr[i]>t_max&&arr[i]<s_max)
            {
                t_max=arr[i];
            }

        }
        if(arr.length<2)
            System.out.println("max = -1");
        else
            System.out.println("Largest = "+max+" Second Largest = "+s_max+" Third Largest = "+t_max);
    }

    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        System.out.println("Enter the size of array");
        int [] arr= new int [size];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        third_largest(arr);


    }
}
