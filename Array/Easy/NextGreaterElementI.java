class Solution { //Brute force 
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i=0;i<nums1.length;i++)
        {
            boolean nogreater = true;
            for(int j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    
                    for(int k = j+1;k<nums2.length;k++)
                    {
                        if(nums2[k]>nums1[i])
                        {
                            nums1[i]=nums2[k];
                            nogreater=false;
                            break;
                        } 
                    }
                    break;
                }
            }
            if(nogreater)
            nums1[i]=-1;
        }
        return nums1;
    }
}

//Time complexity o(n*m) means nums1length * nums2length because first loop will traverse for n time always but inside loop will run maximum of length of m because suppose 
//in worst case we got equal in first element in nums2 jo third loop start from next of index of num2 which matched with nums1 but it will go untill end of nums2 length but it will break
//after coming back for third loop that's why time complexity Order of o(n*m);
