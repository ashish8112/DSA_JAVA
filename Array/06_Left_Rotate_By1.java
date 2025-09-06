package DSA.Array;

import java.util.Scanner;

 class Left_Rotate {
    public static void main(String[] args) {
        int temp,size;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array ");
        size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the elements in the array ");
        for(int i=0;i<size;i++)
            arr[i]=sc.nextInt();
//        int temp2;
//        temp=arr[arr.length-1];
//        for(int i=arr.length-1;i>=0;i--)
//        {
//            if(arr.length>1)
//            {
//                if(i!=0)
//                {
//                    temp2=arr[i-1];
//                    arr[i-1]=temp;
//                    temp=temp2;
//                }
//                else{
//                    arr[arr.length-1]=temp;
//                }
//            }
//        }
        temp=arr[0];
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr.length>1)
            {
                arr[i]=arr[i+1];
            }
        }
        arr[arr.length-1]=temp;
        for(int i=0;i<arr.length;i++)
            System.out.print("\t"+arr[i]);
    }
}
