package DSA.Sorting;

import java.util.Scanner;
// Selection Sort means select the minimum among entire array and shift the first location and shift/swap previous value of first location
// where minimum value got found.
class Selection_Sort {
    static void selectionSort(int [] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int k=i; // k=0 for first time because we have to shift smallest in first palace so k will stop there where smallest value is.
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<arr[k])
                    k=j;
            }
            int temp=arr[k];
            arr[k]=arr[i];
            arr[k]=temp;
        }
    }
    public static void main (String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of Array ");
        int size=sc.nextInt();
        int [] arr= new int [size];
        System.out.println("Enter the elements in Array ");
        for(int i=0;i<size;i++)
            arr[i]=sc.nextInt();
        selectionSort(arr);
        System.out.println("// Array after sorting using Insertion Sort");
        for(int i=0;i<arr.length;i++)
            System.out.printf("%d ",arr[i]);
    }
}
