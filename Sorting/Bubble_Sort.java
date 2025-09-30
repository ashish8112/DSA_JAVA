package DSA.Sorting;
import java.util.*;
public class Bubble_Sort {
//Bubble sort means select consecutive two elements from beginning to end like 0 1 , 1 2 , 2 3 and so on till end
// If previous element is larger than this element for like 2th position element is larger than 3th  position then swap them .
// so we will get the most largest element by end of loop on the end position using swapping
// Every largest will go in end in complete of one entire loop like most largest , second largest that's how and so we need
// to run our outer loop for total number of elements in the array and // inner loop must be decreasing by 1 always because
// during every outer loop last element got it's right position according to sorting. so run inner loop j<n-i;

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
