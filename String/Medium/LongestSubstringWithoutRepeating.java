class Solution { // Brute force 
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
        return 0;
        int max=1;
        int i=0;
        int j=i+1;
        while(j<s.length()&&i<=j)
        {
            int [] freq = new int [256];
            for(int k=i;k<=j;k++)
            {
                freq[s.charAt(k)]++;
            }
            int count =0;
            for(int l=0;l<256;l++)
            {
                if(freq[l]==0)
                continue;
                else if(freq[l]==1)
                count++;
                else{
                    i++;
                    count=1;
                    break;
                }
            }
            max=Math.max(count,max);
            j++;
        }
        return max;
    }
}
