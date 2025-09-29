package DSA.Sorting;

import java.util.Scanner;

public class Insertion_Sort {
    static void insertionSort(int [] arr)
    {
        int j;
        for(int i=1;i<arr.length;i++)
        {
            j=i;
            while(j>=1&&arr[j-1]>arr[j])
            {
                int temp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;
                j--;
            }
        }
    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Array ");
        int size=sc.nextInt();
        int [] arr= new int[size];
        System.out.println("Enter the values in Array ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        insertionSort(arr);
        System.out.println("// Array After Sorting ");
        for(int i=0;i<arr.length;i++)
            System.out.printf("%d ",arr[i]);
    }
}
