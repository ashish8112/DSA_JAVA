class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = weights[0];  
        int sumOfWeights = 0;
        int ans =-1; 
        for(int i=0;i<weights.length;i++)
        {
            max=Math.max(max,weights[i]);
            sumOfWeights+=weights[i];
        }
        int low = max;    //because every weights must be valid to shipped
        int high = sumOfWeights;
        while(low<=high)
        {
            int capacityOfShip = low+(high-low)/2;
            long sum =0;
            int shippingDay =0;
            for(int i=0;i<weights.length;i++)
            {
                if(sum+weights[i]<=capacityOfShip)
                sum+=weights[i];
                else{
                    shippingDay++;
                    sum = weights[i];
                }
            }
            if(sum<=capacityOfShip)
            shippingDay++;
            if(shippingDay<=days)
            {
                high = capacityOfShip -1;
                ans = capacityOfShip;
            }
            else{
                low = capacityOfShip + 1;
            }
        }
        return ans;
    }
}
