package DSA.Sorting;

import java.util.Scanner;
// In insertion sort when we found an element to be small then previous element then we will swap that element to left till
// it is bigger than previous element.
// ex-> 12 13 15 10 8 6
// when i = 4 and j=4 now arr[j-1]>arr[j] so we will start swap(arr[j-1],arr[j]) till j-1!> j so it will not loose order of
// any element as well we can swap the smallest element.
public class Insertion_Sort {
    static void insertionSort(int [] arr)
    {
        int j;
        for(int i=1;i<arr.length;i++)
        {
            j=i;// j will start from i because previous element were sorted in ascending order already.
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
