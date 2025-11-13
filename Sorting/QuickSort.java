package DSA.Sorting;

import java.util.Scanner;

public class QuickSort {
    static void quickSort(int [] arr,int low,int high){
        if(low>=high)
            return;
        int pivot_index=partition(arr,low,high);
        quickSort(arr,low,pivot_index-1);
        quickSort(arr,pivot_index+1,high);
    }
    static int partition(int [] arr, int low,int high){
        int j=low;
        int pivot=arr[high];
        for(int i=low;i<high;i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j++] = temp;
            }
        }
            int temp=arr[high];
            arr[high]=arr[j];
            arr[j]=temp;
        return j;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the Array ");
        int size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the value in array ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
