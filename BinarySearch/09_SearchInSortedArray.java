class Solution {
    public int search(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]==target)
            return mid;
            else if (nums[low]<=nums[mid])    //to check it half is sorted if it is true means left half is sorted.
            {
                if(target>=nums[low]&&target<=nums[mid])  //if left half is sorted we can check if value is between these element then element right else eliminate right
                high=mid-1;
                else
                low=mid+1;
            }
            else if(nums[mid]<=nums[high])
            {
                if(target>=nums[mid]&&target<=nums[high])
                low=mid+1;
                else
                high=mid-1;
            }
        }
        return -1;
    }
}

/*Pattern: Binary Search — Rotated Sorted Array
Trigger: "rotated sorted", "search in rotated", "pivoted array"
Template:
  if(nums[mid]==target) return mid;
  if(nums[low]<=nums[mid]) {         // left sorted
      if(target>=nums[low] && target<=nums[mid]) high=mid-1;
      else low=mid+1;
  } else {                           // right sorted
      if(target>=nums[mid] && target<=nums[high]) low=mid+1;
      else high=mid-1;
  }
Key Insights:
  - Rotated array → ek half hamesha sorted hoga
  - Sorted half identify karo → target range mein hai check karo
  - Agar target sorted half mein nahi → us half ko eliminate karo, dusre pe jao
  - Dusra half "unsorted" lagta hai but next iteration mein woh bhi
    2 parts mein toot jaayega — aur ek side phir sorted hogi!
  - arr[low]<=arr[mid] → left sorted, warna right sorted
Complexity: Time O(log n), Space O(1)*/
