package DSA.Sorting.MergeSort;

import java.util.ArrayList;
import java.util.Scanner;

class Solution{
    public static void mergeSort(int [] arr,int low,int high)
    {
        if(low>=high)
            return;
        int mid=(low+high)/2; // low + (high-low)/2;
        mergeSort(arr,low,mid); // for calling left array or left half
        mergeSort(arr,mid+1,high); // for calling right array or right half
        merge(arr,low,mid,high);// for merging array low to mid which is left array and mid+1 to high is which is a right array.
    }
    public static void merge(int [] arr,int low,int mid,int high)
    {
        int left=low; // starting index of left array
        int right=mid+1;// starting index of right array
        ArrayList<Integer> temp = new ArrayList<>();// dynamic array whose is temp.

        // sorting elements in temp array in a sorted manner.
        while(left<=mid&&right<=high)
        {
            if(arr[left]<=arr[right])
            {
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid) // if element in left array is left.
        {
            temp.add(arr[left]);
            left++;
        }
        while(right<=high) // if element in right array is left.
        {
            temp.add(arr[right]);
            right++;
        }
        // i - low because if 3,3,4 comes in this function arr[3] to arr[4] need to stored with temp[0] and temp[1] because
        // everytime temp is created new while calling this function and stores values from 0 to that much of value.
        for(int i=low;i<=high;i++)
        {
            arr[i]=temp.get(i-low); // arr[3] = temp[0] required so arr[low]=temp.get(3-3) = arr[3]=temp[0]
        }
    }
}

public class MergeSort {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of Array ");
        int size=sc.nextInt();
        int [] arr= new int [size];
        System.out.println("Enter the elements in the Array ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println("Array before Sorting ");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        System.out.println("Array after Sorting Using Merge Sort");
        Solution.mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
