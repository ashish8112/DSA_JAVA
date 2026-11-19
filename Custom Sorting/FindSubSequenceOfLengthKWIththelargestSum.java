class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int [] [] pairs = new int [nums.length][2];
        for(int i=0;i<nums.length;i++)
        pairs[i]=new int [] {nums[i],i};
        Arrays.sort(pairs,(a,b)->b[0]-a[0]);
        int [][] ans = new int [k][2];
        for(int i=0;i<k;i++)
        ans[i]=new int [] {pairs[i][0],pairs[i][1]};
        Arrays.sort(ans,(a,b)->a[1]-b[1]);
        int [] result = new int [k];
        for(int i=0;i<k;i++)
        result[i]=ans[i][0];
        return result;
    }
}
// Time complexity : O(N log N)
// Space complexity : O(N);
