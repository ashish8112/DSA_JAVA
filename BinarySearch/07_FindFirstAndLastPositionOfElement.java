class Solution {
    public static int lowerBound(int [] nums,int target)//first index where arr[i] >= target ,(target exist na kare toh first greater element ka index)
    {
        int low = 0;
        int high = nums.length-1;
        int index = nums.length;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]>=target)
            {
                high = mid-1;
                index = mid;  //if index is not same as target after returning that's means target is not in array becuase we always check left side after
                    //we get greater than our target so it in left side it may our target only or just greater than our target and our low will go till start
              // of array in search of equal or greater element even if we find one (greater or equal) so need to check this index in main that , the index 
              //we have got is matching to our target or not , if not return -1 means there is no starting and end of target in array
            }
            else{
                low=mid+1;
            }
        }
        return index;
    }
    public static int upperBound(int [] nums,int target) //first index where arr[i] > target, (target ka last occurrence + 1)
    {
        int low = 0;
        int high = nums.length-1;
        int index = nums.length;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]>target)
            {
                index = mid;
                high = mid-1;//becuase mujhe left mein hi search karna ki aisa kon sa smallest index hai jo mere target se bada hain 
            }
            else{
                low=mid+1;//agar mere mid ki value mere target se match hai to to right mein dhudhunga ki issey just bada chahiye lekin wo bhi smallest index , 
                //aur smallest index to track mera if condition kar raha hain 
            }
        }
        return index; //becuase suppose sara element match hi hain to size bhej do end ko main mein -1 bas kar dengey aur agar mujhe mere index mil bhi gaya 
                     //jo just greater than my target hai mere array mein just -1 index pe mera end index honga hi 
    }
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums,target);
        if(start==nums.length||nums[start]!=target)
        return new int [] {-1,-1};
        int end = upperBound(nums,target)-1;
        return new int []{start,end};

    }
}


/*Pattern: Binary Search — Lower + Upper Bound Combination
Trigger: "first and last position", "starting and ending index",
         "search range", "occurrence range in sorted array"
Template:
  int start = lowerBound(nums, target);
  if(start == nums.length || nums[start] != target)
      return new int[]{-1, -1};
  int end = upperBound(nums, target) - 1;
  return new int[]{start, end};
Key Insights:
  - Combination problems mein pehle check karo — koi known pattern fit hota hai kya
  - lowerBound + upperBound = O(log n), linear scan = O(n) — always prefer BS
  - Edge case: target exist hi nahi → start == nums.length || nums[start] != target
Complexity: Time O(log n), Space O(1)*/
