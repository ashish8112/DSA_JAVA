package DSA.Array.Medium;
import java.util.*;
class sort_an_array_0_1_2 {
        public static void swap(int [] arr,int i,int j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        public static void sort(int[] arr) {
            int low=0;
            int mid=0;
            int high=arr.length-1;
            while(mid<=high)
            {
                if(arr[mid]==0)
                {
                    swap(arr,low,mid);
                    low++;
                    mid++;
                }
                else if(arr[mid]==1)
                {
                    mid++;
                }
                else if(arr[mid]==2)
                {
                    swap(arr,mid,high);
                    high--;
                }
            }
        }
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the size of the array ");
            int size=sc.nextInt();
            int [] arr= new int[size];
            System.out.println("Enter the values in the array ");
            for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
            sort(arr);
            System.out.println("--- Array after Sorted ---");
            for(int i=0;i<arr.length;i++)
            {
                System.out.print(" "+arr[i]);
            }
        }
    }
