package DSA.Array;

import java.util.Scanner;

public class RotateByElements {
    static void leftRotateByK(int [] arr,int k)
    {
        // 1. In this approach I am moving the k(rotate or 2,3etc ) element from beginning to temp array
        // and then moving all remaining element to the beginning of my actual array .
        // and insert temp array element in the end of my actual array
        // k is used for time rotation like 7 element and 8 rotation means 1 rotation because after 7 rotation it will be original one.
        // visual -> 1 2 3 4 5 -> k=2 -> temp= 1,2 -> actual array= 3 4 5 ||4 5 -> insert temp at end of actual -> 3 4 5 1 2.

        k=k%arr.length;
        int [] temp= new int[k];
        for(int i=0;i<k;i++)
        {
            temp[i]=arr[i];
        }
        for(int i=k;i<arr.length;i++)
        {
            arr[i-k]=arr[i];
        }
        for(int i=arr.length-k;i<arr.length;i++)
        {
            arr[i]=temp[i-(arr.length-k)];
        }


       for(int i=0;i<arr.length;i++)
       {
           System.out.print(arr[i]+"\t");
       }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int [] arr=new int [size];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the element to be rotated from right");
        int rotate=sc.nextInt();
        leftRotateByK(arr,rotate);
    }
}
