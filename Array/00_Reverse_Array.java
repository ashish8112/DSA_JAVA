package DSA.Array;

import java.util.Scanner;

 class Reverse_Array {
    static void reversArray(int [] arr,int start,int end)
    {
        while(start<end)
        {
            int temp=arr[end];
            arr[end]=arr[start];
            arr[start]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int size=sc.nextInt();
        int [] arr= new int[size];
        System.out.println("Enter the elements in array ");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        reversArray(arr,0,size-1);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
