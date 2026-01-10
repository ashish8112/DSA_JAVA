package DSA.Array.Easy.Rotation;

import java.util.Scanner;
// Approach -> In left approach when we are rotating an array by D elements or K elements suppose K is 3
// then reverse the three left most element and then reverse the remaining element from beginning and
// then reverse the entire array like suppose and array of 7 elements 1 2 3 4 5 6 7
// we have to rotate this array by left by three elements so -> 3 2 1 and 4 5 6 7
// we have rotated most three elements from the left now from  remaining elements start from beginning of the array reverse it.
// the remaining elements so it would be ->3 2 1 7 6 5 4 and now reverse this entire array which will be -> 4 5 6 7 1 2 3
//Note: we always reverse array from start to end.

public class RotateLeftByKElement {
    static void reverse(int [] arr,int start,int end)
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

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int size=sc.nextInt();
        int [] arr = new int [size];
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the element to be rotated left ");
        int k=sc.nextInt();
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
