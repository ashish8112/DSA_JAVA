package DSA.Array;

import java.util.Scanner;
// This remove duplicate in sorted array .
class RemoveDuplicate{
    // Two pointer approach.
     static int removeDuplicate(int [] arr)
     {
         int j=0;
         for(int i=0;i<arr.length;i++)
         {
             if(arr[i]!=arr[j])
             {
                 j++;
                 arr[j]=arr[i];
             }
         }
         return j;
     }

     public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);
         System.out.println("Enter the size of array ");
         int size=sc.nextInt();
         int [] arr=new int[size];
         System.out.println("Enter the elements in the array");
         for(int i=0;i<size;i++)
            arr[i]=sc.nextInt();
         int non_duplicate=removeDuplicate(arr);
         System.out.println("Array after removing Duplicate ");
         for(int i=0;i<=non_duplicate;i++)
             System.out.print(arr[i]+" ");
     }
}
