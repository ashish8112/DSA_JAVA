//This is new pattern of min(max) or max(min) we need to short the array to get our output 
class Solution {  //Brute Force
    public boolean isPossible(int [] nums,int d , int cows)
    {
        int countCow=1;
        int lastCordinate = nums[0];    //Greedy approach assuming first position is correct answer.
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


class Solution {    //Optimal
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
        int ans =1;
        int low =1;
        int high = stalls[stalls.length-1]-stalls[0];
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(isPossible(stalls,mid,k)==true)
            {
                ans = mid;
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}

//  Aggressive Cows — Binary Search on Answer

//  Pattern -> min(max) or max(min) type problem

// **1. Why only minimum distance matters (not all pairs):**
// We only need to check consecutive cow placement, not non-consecutive.
//suppose stalls = [1, 3, 4, 8]
// - Example: C1 at 1, C2 at 4, C3 at 8
//   - C1-C2 distance = 3, C2-C3 distance = 4
//   - Minimum = 3  (this is what we maximize)
// - If we check non-consecutively (C1 to C3 = 7), that is always larger and we want minimum so minimum will always come from consecutive pairs because of Sorted

// **2. Why sorted array is needed:**
// We need sorted array so we can apply consecutive distance finding correctly.
// Without sorting, distances between adjacent indices are meaningless.

// **3. Why first cow must be placed at first stall:**
// Suppose k=2, array = [1, 2, 9, 8, 9]
// - Max possible distance = 9 - 1 = 8
// - If we place first cow at any other position, distance will be smaller than 8 because of sorted array
// - So placing first cow at first stall always gives maximum possible answer — greedy choice

// # isPossible() — Greedy Check
// Fix minimum distance = d. Place first cow at stall[0].
// For each next stall, place cow only if distance >= d.
// Count cows placed — if count >= k, return true.

// ### Complexity
// Time: O(n log n) sort + O(n log(max-min)) binary search
// Space: O(1)
