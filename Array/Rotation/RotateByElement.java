package DSA.Array.Rotation;

import java.util.Scanner;

public class RotateByElement {
    static void reverse(int [] arr,int start,int end)
    {
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int size=sc.nextInt();
        int [] arr = new int [size];
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the element to be rotated left ");
        int k=sc.nextInt();
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
