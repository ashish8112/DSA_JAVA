package DSA.Array;

import java.util.Scanner;

 class RemoveDuplicateUnsortedArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the Array ");
        int size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the value in array ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        int k=0;
        int temp[]=new int[arr.length];
        temp[0]=arr[0];// add first element in temp as it is not duplicate or anything.
        for(int i=1;i<arr.length;i++)// from 1st element of array till last element
        {
            int count=0;
            for(int j=0;j<=k;j++) // check individual element of arr to all element of temp
            {
                if(arr[i]==temp[j])// if any element of temp is equal to ith element of array then don't add.
                {
                    count=1;// Not specify at end of this loop that it is  duplicate
                    break;
                }
            }
            if(count!=1)// if not duplicate add to temp.
                temp[++k]=arr[i];
        }
        for(int i=0;i<=k;i++)
        {
            System.out.print(temp[i]+" ");
        }
    }
}
