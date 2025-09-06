package DSA.Array;
import java.util.*;
 class Remove_duplicates {
     static void removeDuplicates(int [] arr)
     {
         int j=0;
         for(int i=0;i<arr.length;i++)
         {
             if(arr[j]!=arr[i]) {                           // if(arr[j]==arr[i])
                 j++;                                       //  j--;
                 arr[j] = arr[i];                           //else{ j++;
             }                                              // arr[j]=arr[i];
         }                                                  // j--; }
         System.out.println("Duplicate removed  ");         //j++;
         for(int i=0;i<=j;i++)
             System.out.println(arr[i]);
     }
     public static void main(String [] args)
     {
      Scanner sc=new Scanner(System.in);
      int size;
         System.out.println("Enter the size of the array ");
         size=sc.nextInt();
         System.out.println("Enter the elements in an array ");
         int [] arr= new int [size];
         for(int i=0;i<arr.length;i++)
         {
             arr[i]=sc.nextInt();
         }
         removeDuplicates(arr);
     }
}
