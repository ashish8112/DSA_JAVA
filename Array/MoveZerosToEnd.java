package DSA.Array;

import java.util.Scanner;

public class MoveZerosToEnd {
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
    static void moviesZerosToEndApproach2(int [] arr)
    {
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
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
