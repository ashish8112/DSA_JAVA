//Just logic is that or intution should be like that if right element from mid is larger means slope array is increasing in right side and our peek element is in 
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
            high=mid;//because mid can be peak element, here right element is smaller than current element so when low pointer comes just one index before high 
            //and if it will be smaller then this element becuase mid < mid+1 so low will be increased to current , low will be peak element.
        }
        return low;//according to upper code when low==high we get our peak element.
    }
}

/*Pattern: Binary Search —> Slope Based (Peak Element)
//How we are solving this, end of array and before start of array is -infinity means single element is peak element as it's left is smaller and right side element is larger.
//while finding mid if next right element of mid < mid+1 is greater than mid means our peak element is might be  mid + 1 element so low=mid+1 . and if just right element of 
// mid is smaller means may be mid is peak element but we are not confirmed that whether just left of previous of mid is smaller than mid or not so we will move our 
// high to mid , high = mid, because main goal to go peak element so suppose low is somewhere already at peak element because just next element of mid was larger so we have 
// already moved low = mid+1 which is may be peak, after calculation when we are always getting right side as smaller than current we are comming to left side using high = mid 
// at some point when low is already at peak because it is greater than previous element we break the loop when low == high becomes because left side of low is already smaller 
// and high is coming form right by decreasing because right side smaller than mid value that index where low == high is peak element, question ask to return any peak element 
// so this is an also valid peak.
// ex 1 3 2 4 5 6 7 , we would think valid ans is 3 as it is peek because it's neighbors are smaller but 7 is also peak element as left of 7 is 6 and right of 7 is -infinity 
// so both ans are correct our approach will return 7 as peak element and it is valid.
Key Insights:
  - Array sorted nahi → slope ke basis pe eliminate karo
  - Boundary -∞ guarantee karta hai ki peak hamesha exist karega
  - low==high pe answer mil jaata hai
  - Multiple peaks allowed → koi bhi ek valid hai
Complexity: Time O(log n), Space O(1)
*/
