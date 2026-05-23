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

//Question -> koko (Monkey) have to eat all banana of piles (collection of banana) but catch is that he wants the minimum speed to eat banana which is less than 
// or equal to  hour(h) is given to monkey and he can eat one pile means one index entirely on one go and if time more left he can go to another pile (index) 
// suppose [2,3] we assumed the speed of eating banana is 3banana per hour so he can eat first index of 2 banana and even 1 unit of time left he cannot move 
//to another index to  eat and if [4,3] so even speed is 3 banana per hour he will take 2 hour to eat first index because if time left while eating one pile 
// it cannot move to another index (pile) so for first index it will take 2 hour to eat 
// we want eating of banana / per hour speed is most minimum which satisfy that is smaller than h or equal to h 

// pattern binary search on answer 
// Approach -> take low as 1 not  minimum of piles of banana array because suppose [3] is array and h = 3 so if we take small as 3 we get ans 3 hour is minimum 
// monkey can maintain to eat which is wrong because ans must be 1 banana per hour  so it can eat in 3 hour easily.
//high can be largest size of ith banana means maximum of array because question stated that given hour >= length of array so if we would take largest of 
// array it  can atleast give us ans which is equall to given h 

