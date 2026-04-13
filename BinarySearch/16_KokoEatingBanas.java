class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        int ans =-1;
        for(int i=1;i<piles.length;i++)
        {
            max=Math.max(piles[i],max);
        }
        int low =1;
        int high = max;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            long time =0; //To avoid overflow in int suppose first pile is int max so adding aything in time (int) will cause overflow.
            for(int i=0;i<piles.length;i++)
            {
                time = time + (long)Math.ceil((double)piles[i]/ mid);//we need 2.3 -> 3 that's why and math.ceil return dobule so we need to type cast it 
            }
            if(time<=h)
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

