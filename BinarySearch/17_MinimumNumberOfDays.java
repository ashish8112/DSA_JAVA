class Solution {
    public int minDays(int[] nums, int m, int k) {
        int ans = -1;
        if(m*k>nums.length)
        return ans;
        int max = nums[0];
        int min = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        int low = min;
        int high = max;
        while(low<=high)
        {
           int mid = low + (high-low)/2;
           int count = 0;
           int bnq = 0;
           for (int i=0;i<nums.length;i++)
           {
               if(nums[i]<=mid)
               count++;
               else{
                   bnq=bnq+count/k;
                   count=0;
               }
           }
            bnq=bnq+count/k;
            if(bnq>=m)
            {
                ans= mid;
                high= mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
}
