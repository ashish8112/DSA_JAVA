package DSA.Sorting;

import java.util.Scanner;

public class RecursiveInsertionSortt {
    static void insertionSort(int [] arr ,int low, int high){
        if(low>high)
            return;
        int j=low;
        while(j>0&&arr[j]<arr[j-1])
        {
            int temp=arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=temp;
            j--;
        }
        insertionSort(arr,++low,high);
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the values in Array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        insertionSort(arr,1,arr.length-1);
        System.out.println("// Array After Sorting ");
        for(int i=0;i<arr.length;i++)
            System.out.printf("%d ",arr[i]);
    }
}
