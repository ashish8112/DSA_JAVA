package DSA.Array;

import java.util.Scanner;
//Write a program to find second largest and second smallest among elements of an array
 class optimal_Second_Highest {
    static int second_max(int [] arr)
    {
        int max=Integer.MIN_VALUE;
        int s_max = Integer.MIN_VALUE; // second largest
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                s_max=max;
                max=arr[i];
            }
            else if(arr[i]>s_max && arr[i]<max)
            {
                s_max=arr[i];
            }

        }
        return s_max;
    }

    static int second_min(int [] arr)
    {
      int min=Integer.MAX_VALUE;
      int s_min = Integer.MAX_VALUE;
      for(int i=0;i<arr.length;i++)
      {
          if(arr[i]<min) // that element is smaller than min value .
          {
              s_min=min; // now second smallest in s_min
              min=arr[i]; // most smallest in min

          }
          else if(arr[i]<s_min&&arr[i]>min) // if value is samller than second most smallest value and greater than most smallest value.
          {
              s_min=arr[i];
          }
      }
      return s_min;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array ");
        int n=sc.nextInt();
        int [] arr= new int[n];
        System.out.println("Enter elements in array ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter elements in array are as follows ");
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
        System.out.println("Second Highest Number is "+second_max(arr));
        System.out.println("Second Minimum Number is "+second_min(arr));
    }
}
