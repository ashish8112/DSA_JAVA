//This is new pattern of min(max) or max(min) we need to short the array to get our output 
class Solution {  //Brute Force
    public boolean isPossible(int [] nums,int d , int cows)
    {
        int countCow=1;
        int lastCordinate = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-lastCordinate>=d)
            {
                countCow++;
                lastCordinate=nums[i];
            }
            if(countCow>=cows)
            return true;
        }
        return false;
    }
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int max = stalls[stalls.length-1];
        for(int i=1;i<=max-stalls[0];i++){
            if(isPossible(stalls,i,k)==true)
            continue;
            else 
            return i-1;
        }
        return max-stalls[0];
    }
}
