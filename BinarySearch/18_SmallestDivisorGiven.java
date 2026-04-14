class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];
        int ans =-1;
        for(int i=0;i<nums.length;i++)
        max=Math.max(nums[i],max);
        int low = 1;
        int high = max;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            long time =0;
            for(int i=0;i<nums.length;i++)
            {
                time = time + (long)Math.ceil((double)nums[i]/mid);
            }
            if(time<=threshold)
            {
                ans=mid;
                high =mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}

/*Pattern: Binary Search on Answer
Trigger: "smallest/largest X such that condition satisfies" — array pe nahi, possible values pe search
Template: low=1, high=max(nums), check(mid) → sum of ceil(nums[i]/mid) <= threshold
Key Insights: ceil(a/b) = Math.ceil((double)a/b), time ko long rakhna zaroori
Complexity: Time O(n log max), Space O(1)*/
