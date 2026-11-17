// Brute: sort kiya par uska faayda nahi uthaya, inner loop phir bhi chala -> O(N^2)
class BruteSolution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] ans = new int [nums.length];
        int [][] pairs = new int [nums.length][2];
        for(int i=0;i<nums.length;i++)
        pairs[i]=new int [] {nums[i],i};
        Arrays.sort(pairs,(a,b)->b[0]-a[0]);
        for(int i=0;i<nums.length;i++)
        {
            int count = 0;
            for(int j=i+1;j<nums.length;j++)
            if(pairs[j][0]<pairs[i][0])count++;
            ans[pairs[i][1]]=count;
        }
        return ans;
    }
}
// Time complexity : O(N^2)
// Space complexity : O(N) 

class BetterSolution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] ans = new int [nums.length];
        int [][] pairs = new int [nums.length][2];
        for(int i=0;i<nums.length;i++)
        pairs[i]=new int [] {nums[i],i};
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        for(int i=0;i<nums.length;i++)
        {
            if(i!=0 && pairs[i][0]==pairs[i-1][0])
            {
                ans[pairs[i][1]]=ans[pairs[i-1][1]];
                
            }
            else
            ans[pairs[i][1]] = i;
        }
        return ans;
    }
}

// Time Complexity : O(N log N)
// Space Complexity : O(N)

// Approach nums = [8, 1, 2, 2, 3], expected answer [4, 0, 1, 1, 3]
// Create pairs of value and it's index -> sort the pairs based on 0th index means values are sorted in ascending order 
// now every pairs has it's own index I am not talking about pairs[0][1] location which is index of original array , I mean every pairs has it's own index 
// 0,1,2 and so on 

// every index of pairs says I am greater than these numbers because values pairs[i][0] are sorted in ascending 0th index means it's pairs[i][0] values is 
// greater than 0 numbers and so on 
// but in case of duplicate first occurence of number will give correct value that I am greater than i number which is index of it's pair , so note that index 
// and set in ans array after that every occurence of same element copy previous one value which is first occurence value 

// visualise 
pairs (value, originalIndex):
(8,0) (1,1) (2,2) (2,3) (3,4)

  ascending sort:
 i:     0      1      2      3      4 <- these are index of pairs array 
     (1,1)  (2,2)  (2,3)  (3,4)  (8,0)

  // for pairs[0][0] which is 1 has 0 number smaller than it's 
  // for pairs [1][0] which is 2 has 1 number smaller than it's 
  // for pairs [2][0] which is 2 it's a duplicate so we will copy the answer of previous occurence which was 1 
  // suppose if again 2 comes we will copy previous occurence which will be also 1 
  
