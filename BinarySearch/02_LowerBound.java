//Brute force
class Solution {
    int lowerBound(int[] arr, int target) {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==target)
            return i;
            else if(arr[i]>target)
            return i;
        }
        return arr.length;
        
    }
}

//Optimal Approach 
class Solution {
    int lowerBound(int[] arr, int target) {
       int ans = arr.length;
       int low = 0;
       int high = ans-1;
       while(low<=high)
       {
           int mid = low+(high-low)/2;
           if(arr[mid]>=target)
           {
           ans=mid;
           high = mid-1;
           }
           else{
               low=mid+1;
           }    
       }
       return ans;   
    }
}

/*Pattern: Binary Search — Save & Eliminate
Trigger: "lower bound", "first occurrence", "leftmost index",
         "first position where arr[i] >= target"
Template:
  int ans = arr.length; // default
  while(low <= high) {
      int mid = low + (high-low)/2;
      if(arr[mid] >= target) {
          ans = mid;       // save kar
          high = mid - 1;  // aur left mein dhoondo
      } else {
          low = mid + 1;
      }
  }
  return ans;
Key Insights:
  - Normal binary search mein found pe return → here save & continue
  - arr.length as default handles "target greater than all elements"
  - low+(high-low)/2 — always overflow safe, good habit
Complexity: Time O(log n), Space O(1)*/
