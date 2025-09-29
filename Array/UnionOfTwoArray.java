package DSA.Array;

import java.util.Scanner;

class UnionOfTwoArray {
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
         return j+1;
     }
     static void unionOfArray(int [] arr1,int n1,int [] arr2,int n2)
     {
         int [] temp = new int [n1];
         int k =-1;
         for(int i=0;i< n1;i++)
         {
             int count =0;
             for(int j=0;j<n2;j++)
             {
                 if(arr1[i]==arr2[j])
                 {
                     k++;
                     temp[k]=arr1[i];
                     count=1;
                     break;
                 }
             }
             if(count!=1)
             {
                 k++;
                 temp[k]=arr1[i];
             }
         }
         for(int i=0;i<n1;i++)
         {
             System.out.print(temp[i]+" ");
         }
     }

     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the size of the array1 and array 2 ");
         int size1,size2;
         size1=sc.nextInt();
         size2=sc.nextInt();
         int [] arr1=new int[size1];
         int [] arr2=new int[size2];
         System.out.println("Enter the values of the array array 1");
         for(int i=0;i<arr1.length;i++)
         {
             arr1[i]=sc.nextInt();
         }
         System.out.println("Enter the values of the array array 2");
         for(int i=0;i<arr2.length;i++)
         {
             arr2[i]=sc.nextInt();
         }
         int j1=removeDuplicate(arr1);
         int j2=removeDuplicate(arr2);
         unionOfArray(arr1, j1,arr2, j2);

     }
}
