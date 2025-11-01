package DSA.Array;

import java.util.Scanner;

class MaximumConsecutive {
    static int maximumConsecutive1(int [] arr)
    {
        int count=0,max=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1)
            {
                count++;
            }
            else{
                max=Math.max(count,max);
                count=0;
            }
        }
        max=Math.max(count,max);
        return max;
    }
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<size;i++)
            arr[i]=sc.nextInt();
        int consecutive=maximumConsecutive1(arr);
        System.out.println("Consective of 1's = > "+consecutive);
    }
}
