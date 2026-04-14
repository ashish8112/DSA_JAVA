class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int high = 0;//will be enitre sum of weights
        int low = weights[0];//will be maximum weight of package
        int ans =-1;
        for(int i=0;i<weights.length;i++)
        {
        high+=weights[i];
        low=Math.max(low,weights[i]);
        }
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int sum =0;
            int cap =0;
            for(int i=0;i<weights.length;i++)
            {
                if(sum+weights[i]<=mid)
                sum+=weights[i];
                else{
                    cap++;
                    sum=weights[i];
                }
            }
            if(sum<=mid)
            cap++;
            if(cap<=days)
            {
                ans = mid;
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

  /*Pattern: Binary Search on Answer
Trigger: "minimum capacity/speed/divisor such that condition satisfies within limit"
Template: low=max(weights), high=sum(weights), check(mid) → count ships <= days
Key Insights: low = max(weights) — physically impossible below this
              high = sum(weights) — worst case, 1 package per day
              after loop cap++ — last ship count karna mat bhoolo
Complexity: Time O(n log(sum-max)), Space O(1)*/
}
