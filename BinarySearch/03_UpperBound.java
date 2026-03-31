//Brute Approach
class Solution {
    int upperBound(int[] arr, int target) {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>target)
            return i;
        }
        return arr.length;
    }
}

//Optimal Approach
class Solution {
    int upperBound(int[] arr, int target) {
        int ans = arr.length;
        int low=0;
        int high = ans-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]<=target)
            low=mid+1;
            else {
                ans = mid;
                high=mid-1;
            }
        }
        return ans;
    }
}

/*Pattern: Binary Search — Save & Eliminate (Lower/Upper Bound)
Trigger: "lower bound", "upper bound", "first occurrence",
         "leftmost index", "insert position", "sorted array + index"

Template:

  // Lower Bound — pehla index jahan arr[i] >= target

  int ans = arr.length;
  while(low <= high) {
      int mid = low + (high-low)/2;
      if(arr[mid] >= target) {
          ans = mid;
          high = mid - 1;
      } else {
          low = mid + 1;
      }
  }

  // Upper Bound — pehla index jahan arr[i] > target

  // Sirf >= ki jagah > karo, aur low/high swap karo

  if(arr[mid] <= target) low = mid + 1;
  else { ans = mid; high = mid - 1; }

Key Insights:

  - Normal BS mein found pe return → Bound mein found pe save & continue
  - ans = arr.length as default — target sab se bada ho toh handle hoga
  - low+(high-low)/2 — always overflow safe, (low+high)/2 kabhi mat likho

Complexity: Time — O(log n), Space — O(1)*/
