class Solution {
    public int minDays(int[] nums, int m, int k) {
        int ans = -1;
        if(m*k>nums.length)
        return ans;
        int max = nums[0];
        int min = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        int low = min;
        int high = max;
        while(low<=high)
        {
           int mid = low + (high-low)/2;
           int count = 0;
           int bnq = 0;
           for (int i=0;i<nums.length;i++)
           {
               // if(mid>=bloomDay[i])
               //  count++;
               //  else
               //  count=0;
               //  if(count>=k)
               //  {
               //      bnq++;
               //      count=0;
               //  }
               if(nums[i]<=mid)
               count++;
               else{
                   bnq=bnq+count/k;
                   count=0;
               }
           }
            bnq=bnq+count/k;
            if(bnq>=m)
            {
                ans= mid;
                high= mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
}
// Question wants use to create a bonquet of adjacent k flowers means if there are five values in array, there are 5 flower in garden and each index states the 
// blooming Day of that flower so suppose that there is a customer who wants m=2 (2 banquet) which consist of k=3(3 flowers) then we should find 3 consecutive index only 
// to get 1 banquet (3 flower) and each flower must bloomed , means gardener must pick flower after bloomed means (value of index must be equall or smaller than 
// the day of gardener went to pick the flower). Question wants minimum days to create a banquet of k flowers 
// Note every index is 1 flower and value at index states blooming day not number of flower there will be only n means length of array
// flower not more and small then that.
//Pattern : Binay Search 
//Approach : find range for binary search, low must be smallest day where atleast one flower can bloom and high is the day where all flowers are bloomed which 
// is the maximum value of array. then taking a day as mid and check wether consecutive flower of k can be possible for m banquet if yes then choose less day 
// because question wants minimum day to create banquet so high = mid -1 if(banquet>=m) else low = mid+1;
// we need to check every mid value to statisfy the condition so we need entire traversal of array with that mid (day)

// Time complexity = o(n) + o(n*(log(max(arr)-min(arr)))) = o(n log(max(arr)-min(arr)))
// space complexity = o(1)

