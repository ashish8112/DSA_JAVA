//Note in this our array is sorted
//Just logic is that our intution should be like that if right element from mid is larger means slope array is increasing in right side and our peek element is in 
//right side else if our left side element of mid is larger means peak is in left if both are smaller means our mid is peak element .

class Solution {
    public int findPeakElement(int[] nums) {
        int low =0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(mid!=nums.length-1&&nums[mid]<nums[mid+1])
            low=mid+1;
            else{
                if(mid==0||nums[mid]>nums[mid-1])
                return mid;
                high = mid-1;
            }   
        }
        return -1;//default value for return 
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int low =0;
        int high = nums.length-1;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]<nums[mid+1])
            low=mid+1;
            else
            high=mid;//because mid can be peak element
        }
        return low;//according to upper code when low==high we get our peak element.
    }
}

/*Pattern: Binary Search — Slope Based (Peak Element)
Trigger: "peak element", "local maximum", "greater than neighbors"
Template:
  while(low < high) {
      int mid = low+(high-low)/2;
      if(nums[mid] < nums[mid+1]) low = mid+1;  // go right
      else high = mid;                            // go left
  }
  return low;
                            or
    while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(mid!=nums.length-1&&nums[mid]<nums[mid+1])
            low=mid+1;        //means slope of array is increasing in right side
            else{
                if(mid==0||nums[mid]>nums[mid-1])
                return mid;
                high = mid-1;  //right side of array is decreasing.
            }   
        }
Key Insights:
  - Array sorted nahi → slope ke basis pe eliminate karo
  - Boundary -∞ guarantee karta hai ki peak hamesha exist karega
  - low==high pe answer mil jaata hai
  - Multiple peaks allowed → koi bhi ek valid hai
Complexity: Time O(log n), Space O(1)*/
