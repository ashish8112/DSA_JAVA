class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<time.length;i++)
        min=Math.min(min,time[i]);
        long high = (long)min*totalTrips;
        long ans = high;
        while(low<=high)
        {
            long mid = low+(high-low)/2;
            long times = 0;
            for(int i=0;i<time.length;i++)
            times+=(long)Math.floor((double)mid/time[i]);
            if(times>=totalTrips)
            {
                ans = mid;
                high = mid-1;
            }
            else
            low=mid+1;
        }
        return ans;
    }
}
// Time complexity : O(n*(log(min*totalTrips)))
// Space complexity : O(1)
