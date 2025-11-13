package DSA.Sorting;

import java.util.Scanner;
// In each recursion call the largest element gets it last position.
public class RecursiveBubbleSort {
    static void bubbleSort(int [] arr,int low,int high){
        if(low>=high)
            return;
        for(int i=low;i<high;i++)
        {
            if(arr[i]>arr[i+1])
            {
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        bubbleSort(arr,low,high-1);
    }
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<size;i++)
            arr[i]=sc.nextInt();
        bubbleSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
