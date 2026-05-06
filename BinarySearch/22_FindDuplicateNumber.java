class Solution { //But it violates the constraint of o(1) space complexity but time complexity is o(n).
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
        if(!set.contains(nums[i]))    // time complexity o(1) because back in hood it uses hashmap
        set.add(nums[i]);
        else
        return nums[i];
        }
        return -1;
    }
}
//Better with o(1) space complexity and time complexity o(n log n)
class Solution {
    public int findDuplicate(int[] nums) {
        int low =1;
        int high = nums.length-1;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            int count =0;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]<=mid)
                count++;
            }
            if(count<=mid)
            low=mid+1;
            else
            high = mid;
        }
        return low;
    }

    //Searching on number and checking if number of count <= mid of range of 1 to n-1(size of array -1) 
    //we check if number of count <= mid of range 1 to n-1 , and count updated using array elements 
    //if count is greater than mid value means extra number is forciblily pushed in left side of search range from mid so we need to check in left 
    //by high =  mid becuase mid can be duplicate number not mid -1 because we can miss potential value 
    // if count is small or equal to mid means no extra value in left array , so it must be right side if duplicate exists 
    //when low == high means we got our duplicate value 
}
```
