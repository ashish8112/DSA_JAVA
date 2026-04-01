class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = nums.length;
        int low =0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]>=target)
            {
                index=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return index;
    }
}

/*Search Insert Position = Lower Bound exactly!
Target mile ya na mile → pehla index jahan nums[i] >= target
Agar target array mein nahi → wahi index jahan insert karna hai
Complexity: Time O(log n), Space O(1)*/
