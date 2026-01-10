package DSA.Array.Easy.Rotation;

import java.util.Scanner;

import static java.lang.System.exit;

 class RotateByElements {
    static void leftRotateByK(int [] arr,int k)
    {
        // Approach for left rotation save all k elements from most left or beginning of elements/array .
        // 1. In this approach I am moving the k(rotate or 2,3etc ) element from beginning to temp array
        // and then moving all remaining element to the beginning of my actual array beginning because all starting elements till k
        // have moved to temp array . and now when we subtract k from remaining element index it will point from starting
        // like k=3 then 0,1,2nd position elements have removed then 3th position will go 0th position 3-k(3) = 0 and that's further.
        // after moving to starting of array then insert temp array element in the end of my actual array.
        // if size of array is 7 then 7-k(3) = 4th , 5th and 6th element will be filled by temp[0],temp[1],temp[2] respectively.
        // k is used for time rotation like 7 element and 8 rotation means 1 rotation because after 7 rotation it will be original one.
        // visual -> 1 2 3 4 5 -> k=2 -> temp= 1,2 -> actual array= 3 4 5 ||4 5 -> insert temp at end of actual -> 3 4 5 1 2.

        k=k%arr.length;
        int [] temp= new int[k];
        for(int i=0;i<k;i++)
        {
            temp[i]=arr[i];
        }
        for(int i=k;i<arr.length;i++) // for(int i=0;i<arr.length-k;i++)
        {
            arr[i-k]=arr[i];            //arr[i]=arr[i+k];
        }
        for(int i=arr.length-k;i<arr.length;i++)
        {
            arr[i]=temp[i-(arr.length-k)];
        }


       for(int i=0;i<arr.length;i++)
       {
           System.out.print(arr[i]+"\t");
       }
    }

    // Right rotate by k element ;
    static void rightRotateByK(int [] arr,int k)
    {
        // Approach for right rotation save all k elements from most right or end of elements/array .
        k=k%arr.length;
        int [] temp= new int [k];
        //storing k element from most right of array in temp array.
        for(int i=arr.length-k;i<arr.length;i++)  //for(int i=0;i<k;i++)// if k=4 , for 7 element we took 4 element
            temp[i-(arr.length-k)]=arr[i];            //temp[i]=nums[i+nums.length-k];

        // replacing the values of array from left to right of remaining elements after removing k elements above.
        //like k=3 means 3 elements from last copied temp and now 4 elements from left need to shift right.
        // i=6 for ttl 7 elements arr[6]=arr[6-3] so in 6th position -> 3rd value , 5th-> 2 , 4th-> 1, 3rd -> 0th value.
        for(int i=arr.length-1;i>=k;i--)
        {
            arr[i]=arr[i-k];
        }
        for(int i=0;i<k;i++)
            arr[i]=temp[i];

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"\t");
        }

    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int rotate;
        System.out.println("Enter the size of array");
        int size=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int [] arr=new int [size];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        while(true) {
            System.out.println("Enter 1 for Left Rotate, Enter 2 for right rotate and Enter 3 for exit ");
            int number=sc.nextInt();
            int [] real_arr=arr.clone();
            switch(number) {
                case 1: System.out.println("Enter the element to be rotated from left");
                     rotate = sc.nextInt();
                    leftRotateByK(real_arr, rotate);
                    break;
                case 2:System.out.println("Enter the element to be rotated from right");
                     rotate = sc.nextInt();
                    rightRotateByK(real_arr, rotate);
                    break;
                case 3:
                    exit(0);
            }
        }
    }
}
