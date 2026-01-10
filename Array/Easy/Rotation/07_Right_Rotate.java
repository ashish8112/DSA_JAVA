package DSA.Array.Easy.Rotation;

import java.util.Scanner;

class Right_Rotate {
    //Notice optimal approach which is used in left rotate , I used to begin my rotation of array from begin for left .
    // And for right rotate I started rotating my array from the end .
    // Think like that for left rotation think from most left element and for right think from right most element.
    static void rightRotateBY1(int [] arr)
    {
      int temp=arr[arr.length-1];
      for(int i=arr.length-1;i>0;i--)
      {
          arr[i]=arr[i-1];
      }
      arr[0]=temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size=sc.nextInt();
        int [] arr= new int[size];
        System.out.println("Enter the elements in the array ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        rightRotateBY1(arr);
        System.out.println("Array after right rotation by 1");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
