package DSA.Array.Easy;

import java.util.Scanner;

class MissingNumber {
    static int bruteMissingNumber(int [] nums)
    {
        for(int i=1;i<=nums.length;i++)
        {
            int flag=0;
            for(int j=0;j<nums.length;j++)
            {
                if(i==nums[j])
                {
                    flag=1;
                    break;
                }
            }
            if(flag!=1)
                return i;
        }
        return 0;
    }
    static int optimisedMissingNumber(int [] nums)
            //As we know sum from 1 to N is (n * (n+1))/2 so we can sum entire array value and subtract from total sum
    {
        int sum = 0;
        for (int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        return (((nums.length*(nums.length+1))/2) - sum);
    }

    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the Array ");
        int size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the value in array ");
        System.out.println("You can enter number from 0 to Size of array number only 0 to N and only missing number should be there ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        //int missingNumber=bruteMissingNumber(arr);
        int missingNumber=optimisedMissingNumber(arr);
        System.out.println("Missing Number = "+missingNumber);
    }
}
