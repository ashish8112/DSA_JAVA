package DSA.Sorting;
import java.util.*;
public class Bubble_Sort {

    static void bubbleSort(int n)
    {
        Scanner sc=new Scanner(System.in);
        int [] arr=new int [n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++) // On first loop most largest element will be in the end. and then like that second largest in second last position in second loop.
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        print(arr);
    }
    static void print(int array[] )
    {
        for(int i=0;i< array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();// size of array will pass to bubble sort method.
        for (int i = 1; i <= n; i++) {
            int number;
            number = sc.nextInt();
            bubbleSort(number);

        }
    }
}
