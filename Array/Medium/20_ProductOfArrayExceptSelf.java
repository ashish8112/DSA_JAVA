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
