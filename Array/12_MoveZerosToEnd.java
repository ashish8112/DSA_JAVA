package DSA.Array;

import java.util.Scanner;

 class MoveZerosToEnd {
    //This is similar to removing duplicates if arr[i] not equal to zero then put in arr[j] where j is at 0th position means
    // from entire array if i found non-zero element , it will assign to jth position note j position only iterate if it stores
    // non-zero element after traversal to end of array only non-zero are at the beginning and some unwanted values are left behind.
    // so again start filling zero till end from the starting where last j filled non-zero .
    static void moveZerosToEndApproach1(int [] arr)
    {
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                arr[j]=arr[i];
                j++;
            }
        }
        for(int i=j;i<arr.length;i++)
            arr[i]=0;
    }
    // In this approach if arr[i] and arr[j] will be non-zero they will swap each other at some location and move forward together.
    // which will have no effect . suppose if arr[i] is 1st position which is 0 and j is also at 1st location because both are
    // moving together but now this time j will stop at 1st position because arr[i]==0 , so again i will iterate but j will be at
    //1st location because iteration of j only happen if arr[i] find non-zero , now again if in upcoming elements there are
    //several zero element it will skip and continued It's iteration and when arr[i] get non-zero it will swap that element to
    // location arr[j] which was 1st and then j iterate there becomes 2nd that's how swapping with order is happening . and if in
    // upcoming elements there would be no non-zero so no swapping will be done and all non-zero are moved to front and all zeros are
    // at the end.

    static void moviesZerosToEndApproach2(int [] arr)
    {
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<size;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter 1 for Approach 1 or Enter 2 for Approach 2");
        int approach=sc.nextInt();
        if(approach==1)
            moveZerosToEndApproach1(arr);
        else
            moviesZerosToEndApproach2(arr);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
