class Solution {
    int floorSqrt(int n) {
        int low=1;
        int high = n;
        int ans = 1;
        while(low<=high)
        {
            long mid = low+(high-low)/2;
            if(mid*mid<=n)
            {
            low=(int)(mid+1);
            ans = (int)mid;
            }
            else
            high=(int)(mid-1);
        }
        return ans;
    }
}

/*Pattern: Binary Search — Save & Eliminate (Floor Variant)
Trigger: "floor square root", "largest integer whose square <= n"
Template:
  long mid = low+(high-low)/2;
  if(mid*mid<=n) { ans=(int)mid; low=(int)(mid+1); }
  else high=(int)(mid-1);
Key Insights:
  - mid ko long rakho — mid*mid int overflow kar sakta hai
  - Floor/Ceil pattern jaisa — save & go right for valid answer
  - high=n rakho — sqrt(n) kabhi n se bada nahi hoga
Complexity: Time O(log n), Space O(1)*/
