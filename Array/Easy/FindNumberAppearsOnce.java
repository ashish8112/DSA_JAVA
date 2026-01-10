package DSA.Array.Easy;

import java.util.Scanner;

public class FindNumberAppearsOnce {
    public static void findNumberAppearOnce(int [] arr)
    {
        int xor=0;
        for(int i=0;i<arr.length;i++)
        {
            xor=xor^arr[i];
        }
        System.out.println(xor+" this number appear once");
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of the array ");
        Scanner sc= new Scanner(System.in);
        int size=sc.nextInt();
        int [] arr= new int [size];
        System.out.println("Enter the values in the array ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        findNumberAppearOnce(arr);
    }
}
