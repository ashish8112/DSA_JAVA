package DSA.Recursion;

import java.util.Scanner;

public class ReverseArrayUsingRecursion {
    void reverseArray(int [] arr,int start,int end)
    {
        if(start>end)
            return;
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        reverseArray(arr,start+1,end-1);

    }

    public static void main(String[] args) {
        ReverseArrayUsingRecursion obj=new ReverseArrayUsingRecursion();
        Scanner sc= new Scanner (System.in);
        System.out.println("Enter the size of array");
        int size=sc.nextInt();
        int [] arr= new int[size];
        System.out.println("Enter the elements in the array ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        obj.reverseArray(arr,0,arr.length-1);
        System.out.println("Array after reverse");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
