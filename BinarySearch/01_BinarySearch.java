class Solution {
    public int search(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;
        while(low<=high)//which low<=high because in even number of array low and high can be same and target can be that so if we skip we loose ans.
        {
            int mid = low+(high-low)/2;  // to avoid overflow
            if(nums[mid]==target)
            return mid;
            else if (nums[mid]<target)
            low=mid+1;
            else 
            high=mid-1;
        }
        return -1;
    }
}
