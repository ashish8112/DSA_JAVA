package DSA.Array.Easy.Rotation;

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
        // 1st apprach -> Shifting values from the end of the array
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
        // 2nd Approach , Optimal ->Shifting  from begin of array like 1st element in 0th element and that's like
        temp=arr[0];
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr.length>1)
            {
                arr[i]=arr[i+1];
            }
        }
        arr[arr.length-1]=temp;
        //3rd Approach shifting forth element in previous element like shifting 2nd element in 1st element.
//        temp=arr[0];
//        for(int i=1;i<arr.length;i++)
//        {
//            arr[i-1]=arr[i];
//        }
//        arr[arr.length-1]=temp;

        //Printing rotated element.
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"\t");
    }
}
