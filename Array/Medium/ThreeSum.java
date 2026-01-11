package DSA.Array.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {
    public static int[] threeSum(int [] arr,int target)
    {
        int [] [] numberwithindex = new int [arr.length][2];
        for(int i=0;i<arr.length-2;i++)// arr.length-2 becuase when I am last 3rd element 4th will catch by low = i+1 and last with high;
        {
            numberwithindex[i][0]=arr[i];
            numberwithindex[i][1]=i;
        }
        Arrays.sort(numberwithindex,(a, b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<arr.length;i++)
        {
            int el=numberwithindex[i][0];
            int low = i+1;
            int high=arr.length-1;
            while(low<high)
            {
                int sum = el+numberwithindex[low][0]+numberwithindex[high][0];
                if(sum==target)
                    return new int [] {numberwithindex[i][1],numberwithindex[low][1],numberwithindex[high][1]};
                else if(sum<target)
                    low++;
                else high--;
            }
        }
     return new int [] {-1,-1,-1};
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the size of the array ");
        int size=sc.nextInt();
        int [] arr = new int [size];
        System.out.println("Enter the values in the arrya ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the target for Three Sum addition ");
        int target=sc.nextInt();
        int [] number = threeSum(arr,target);
        if(number[1]!=-1)
            System.out.println(number[0]+" "+number[1]+" "+number[2]);
    }
}
