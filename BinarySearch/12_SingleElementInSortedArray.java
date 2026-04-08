class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low =0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(mid%2==0)//for even index
            {
               if(mid!=nums.length-1&&nums[mid]==nums[mid+1])
               low=mid+1;
               else{//becuase every pair start from even index to odd if we don't find pair on even index ,it might be we got single index , 
                // now we just need to check left side where it broke first time so we can get single index 
                ans=nums[mid];
                high=mid-1;
               }
            }
            else{//for odd index 
                if(nums[mid]==nums[mid-1])
                low=mid+1;
                else{//at odd index we can only got to know that it is broked (pair) somewhere so we need to check our left side that where it is broken 
                 // becuase pair starts from even so if at odd index we didn't get same value so we need to find fist even index where it broked becuase
                // before that index every even and odd index are perfectly aligned with pair 
                    high=mid-1;
                }
            }
        }
        return ans;
    }
}

/*Pattern: Binary Search — Single Element in Sorted Array (Index Based Pattern)
Trigger: "single element", "every element twice except one", O(log n) required
Template:
  if(mid%2==0) {                          // even index
      if(mid!=nums.length-1 && nums[mid]==nums[mid+1]) low=mid+1;
      else { ans=nums[mid]; high=mid-1; }
  } else {                                // odd index
      if(nums[mid]==nums[mid-1]) low=mid+1;
      else high=mid-1;
  }
Key Insights:
  - Single element hamesha EVEN index pe hoga
  - Even index pe pair → next index same hona chahiye, nahi toh left mein single
  - Odd index pe pair → prev index same hona chahiye, nahi toh left mein single
  - mid==nums.length-1 edge case → last element single hai
Complexity: Time O(log n), Space O(1)*/
