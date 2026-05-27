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
            
            if(sum<=capacityOfShip)    // or directly shippingDay++ because if condition will always be true no matter what . Reasons is written below.
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
//We have to find a smallest limit in which we can fill packages to get minimum weight which can be used to ship the weight within given days to ship.
//pattern : Binary Search on answers with greedy Appraoch , similar Problem see to Book alloacation Problem
//approach : we should start with maximum weight because ship must load every weight if shippment weight is smaller than package weight and than one enitre ship 
// will not also able to carry that package so that is invalid weight of ship so start with maximum of array (maximum weight of package) and hgih must be some
// of all weights so it can shipped in most least number of days which is practically 1 , so entire package  can be shipped in 1 day . 

//Problem why at last (sum<=capacityOfShip) because it starts with maximum of array (value) so even the last value is exist in weight it will come under the 
// capacityOfShip so +1  only and if last value exceed the capacity inner loop else will execute and add one more day of shippment and remaining weight will surely
// come under capacityOfShip because a single last value can be maximum of which is lowest of our range so it is valid to increase one day 
// and another case if all weights come inside the capacityofship and else part of loop doesn't execute so after loop shippingDay ++ is necessary and valid 
// so conclusion is this we have to increase one day ++ after the loop and no need to check sum <=capacityOfShip but for more readibility and understanding 
// I have written that if condition will always be true no matter what
