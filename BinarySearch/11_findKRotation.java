class Solution {
    public int findKRotation(int arr[]) {
        int min = 0;
        int low =0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<=arr[min])
                min=low;
                low=mid+1;
            }
            else{
                if(arr[mid]<=arr[min])
                min=mid;
                high=mid-1;
            }
        }
        return min;
    }
}

/*Pattern: Binary Search — Find K Rotation (Minimum Index)
Trigger: "how many times rotated", "find rotation count", "index of minimum"
Template:
  int min = 0; // minimum element ka index track karo
  if(arr[low]<=arr[mid]) {       // left sorted
      if(arr[low]<=arr[min]) min=low;
      low=mid+1;
  } else {                       // right sorted
      if(arr[mid]<=arr[min]) min=mid;
      high=mid-1;
  }
  return min;
Key Insights:
  - K rotation = index of minimum element
  - Left sorted  → nums[low] is min of that half → compare with global min
  - Right sorted → nums[mid] is min of that half → compare with global min
  - Find Minimum (LC153) ka hi extension hai!
Complexity: Time O(log n), Space O(1)*/
