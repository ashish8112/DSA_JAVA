class Solution {  //OverComplexed
    public int findMin(int[] nums) {
       int low = 0;
       int high = nums.length-1;
       int min =nums[0];
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]<min)
            {
                min=nums[mid];
            }
            if(nums[low]<=nums[mid])
            {
                if(nums[mid]<=nums[high])
                {
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                high=mid-1;
            }
        }
        return min;
    }
}

//Optimize of above complexed approach
class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int high = nums.length-1;
        int min = nums[0];
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[low]<=nums[mid])
            {
                min=Math.min(min,nums[low]);
                low=mid+1;
            }
            else{
                min=Math.min(min,nums[mid]);
                high=mid-1;
            }
        }
        return min;
    }
}


// Rotated array → ek side sorted, ek side unsorted
//                 [4,5,6,7,0,1,2] → left sorted, right unsorted

// Not rotated   → dono side sorted dikhenge
//                 [0,1,2,4,5,6,7] → left sorted, right sorted bhi

/*Pattern: Binary Search — Minimum in Rotated Sorted Array
Trigger: "minimum in rotated", "find pivot", "rotation point"
Template:
  int min = nums[0];    //if  time constraint is minimum of length of 1
  if(nums[low]<=nums[mid]) {        // left sorted
      min = Math.min(min,nums[low]);
      low = mid+1;                //Now search in right half
  } else {                          // right sorted
      min = Math.min(min,nums[mid]);
      high = mid-1;              //now search in left half
  }
Key Insights:
  - Left sorted  → nums[low] is min of that half 
  - Right sorted → nums[mid] is min of that half
  - Minimum wali side eliminate karo — dusri side mein smaller ho sakta hai
  - LC 33 jaisa hi — bas target dhundhne ki jagah minimum track karo
Complexity: Time O(log n), Space O(1)*/
