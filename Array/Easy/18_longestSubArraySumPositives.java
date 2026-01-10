package DSA.Array.Easy;
import java.util.*;
class longestSubArraySumPositives {
    static int longestSubArraySum(int [] arr,int target)
    {
        int sum=0;
        int j=0;
        int maxLength=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum==target)
            {
                maxLength=Math.max(maxLength,i-j+1);
            }
            while(j<=i&&sum>target)
            {
                sum-=arr[j++];
                if(sum==target)
                {
                    maxLength=Math.max(maxLength,i-j+1);
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
     System.out.println("Enter the size of the array ");
     Scanner sc= new Scanner(System.in);
     int size=sc.nextInt();
     int [] arr= new int [size];
     System.out.println("Enter the values in the array ");
     for(int i=0;i<arr.length;i++)
     arr[i]=sc.nextInt();
     System.out.print("Enter the target for the longest subaaray ");
     int target=sc.nextInt();
     int length=longestSubArraySum(arr,target);
     System.out.println("Length of target " + target + " is " + length);
    }
}
