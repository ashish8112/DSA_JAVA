class Solution {  //Brute Force
    public int[] productExceptSelf(int[] nums) {
        int [] ans = new int [nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int product=1;
            for(int j=0;j<nums.length;j++)
            {
                if(i!=j)
                product*=nums[j];
            }
            ans[i]=product;
        }
        return ans;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {    //better
        boolean zero = false;
        int count =0;
        int product = 1;
        int [] ans = new int [nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            product*=nums[i];
            else{
                count++;
                zero=true;
            }
            if(count>1){
                return ans;
            }
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            ans[i]=product;
            else if(zero!=true)
            ans[i]=product/nums[i];
            else 
            ans[i]=0;
        }
        return ans;
    }
}

/*Pattern: Prefix/Suffix Product
Trigger: product of array except self — division not allowed
Template: prefix[i] = prefix[i-1]*nums[i-1], suffix[n-i] = suffix[n-i+1]*nums[n-i+1]
          ans[i] = prefix[i] * suffix[i]
Key Insights: prefix[i] = product of all elements LEFT of i
              suffix[i] = product of all elements RIGHT of i
              ans[i] = left product * right product
Complexity: Time O(n), Space O(n) — O(1) possible with running suffix variable*/

