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
    
    public static int longestSubarray(int[] arr, int k) { //Optimal Approach
        int maxLength=0;
        int sum =0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);//to handle case sum==k , suppose [3] k = 3 so sum is 3 in loop and if we will try to check is current sum - k exists which is 0 
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
                int rem=sum-k;
                if(map.containsKey(rem))
                {
                    maxLength=Math.max(maxLength,(i-map.get(rem)));
                }
            
            if(!map.containsKey(sum))//to avoid overwrite suppose [2,3,1,2,2,-5] check last value hashmap of 5 at end of hashmap
            map.put(sum,i);
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
     int length=longestSubarray(arr,target);
     System.out.println("Length of target " + target + " is " + length);
    }
}

/*Pattern: Prefix Sum + HashMap
Trigger: "longest subarray with sum k", negative numbers allowed
Template:
  map.put(0,-1); // base case
  for each element:
      sum += arr[i]
      rem = sum - k
      if(map.containsKey(rem)) → update maxLength
      if(!map.containsKey(sum)) → map.put(sum, i) // to avoid overwrite
Key Insights:
  - sum-k pehle kab aaya → tab se abhi tak sum=k
  - map.put(0,-1) → sum==k case handle karta hai
  - Pehla index store karo — longest subarray milega
Complexity: Time O(n), Space O(n)*/
