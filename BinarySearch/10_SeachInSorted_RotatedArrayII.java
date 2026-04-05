//It is same like previous question the main problem is that if array contains duplicate it is not normal scenario to find sorted half and target 
//suppose target is 0 and arr =[1 0 1 1] so mid is 1 and low is also 1 so , left half sorted condition fullfilled arr[low]<=arr[high] but when we check 
//target lies between low and mid our check condition will failed becuase 0 is not greater or equal to 1(low) and smaller or equal to 1(mid) , so we will 
//eliminate left half so cannot get answer any how in future with right half so in duplicate only this is will be failed when arr[low]=arr[mid]=arr[high]
//becuase both half will seems sorted but one is not so what will we do we will shrink array and why shrinking because if arr[mid]!=target it means arr[low] as 
// well as arr[high] also cannot be target and because of same it is impossible to find correct sorted half so shrink the low with low+1 and high = high-1;
//and then we can perfom normal finding half sorted array .
class Solution {
    public boolean search(int[] nums, int target) {
         int low=0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]==target)
            return true;
            else if(nums[low]==nums[mid]&&nums[mid]==nums[high])
            {
                high--;
                low++;
            }
            else if (nums[low]<=nums[mid])
            {
                if(target>=nums[low]&&target<=nums[mid])
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
        return false;
    }
}

/*Pattern: Binary Search — Rotated Sorted Array with Duplicates (LC 81)
Trigger: "rotated sorted", "duplicates allowed", "search in rotated"
Template:
  if(arr[low]==arr[mid]&&arr[mid]==arr[high]) { low++; high--; } // shrink
  else if(nums[low]<=nums[mid]) {         // left sorted
      if(target>=nums[low] && target<=nums[mid]) high=mid-1;
      else low=mid+1;
  } else {                                // right sorted
      if(target>=nums[mid] && target<=nums[high]) low=mid+1;
      else high=mid-1;
  }
Key Insights:
  - Duplicates → arr[low]==arr[mid]==arr[high] → sorted half identify impossible
  - Shrink karo → arr[low] aur arr[high] target nahi (mid se already check hua)
  - Baaki sab LC 33 jaisa!
Complexity: Time O(log n) avg, O(n) worst case (all duplicates)*/
