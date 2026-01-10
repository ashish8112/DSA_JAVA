package DSA.Array.Easy.Rotation;

import java.util.Scanner;

public class RotateRightByKElement {
    static void reverse(int []arr,int start,int end)
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
    // Approach -> In right approach when we are rotating an array by D elements or K elements suppose K is 3
    // then reverse the three right most element and then reverse the remaining element from beginning and
    // then reverse the entire array like suppose and array of 7 elements 1 2 3 4 5 6 7
    // we have to rotate this array by right by three elements so -> 1 2 3 4 and 7 6 5
    // we have rotated most three elements from the right now from beginning of the array reverse
    // the remaining elements so it would be ->4 3 2 1 7 6 5 and now reverse this entire array which will be -> 5 6 7 1 2 3 4
    //Note: we always reverse array from start to end.
   public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int size=sc.nextInt();
        int [] arr = new int [size];
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the element to be rotated right ");
        int k=sc.nextInt();
        reverse(arr,arr.length-k,arr.length-1);
        reverse(arr,0,k);
        reverse(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
