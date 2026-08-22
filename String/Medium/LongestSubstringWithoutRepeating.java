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

        class Solution { // Brute but better than above for readiblity 
    public int lengthOfLongestSubstring(String s) {
        int maxLength =0;
        for(int i=0;i<s.length();i++)
        {
            int [] freq = new int [256];
            for(int j=i;j<s.length();j++)
            {
                if(freq[s.charAt(j)]==1)
                break;
                freq[s.charAt(j)]++;
                maxLength=Math.max(maxLength,(j-i+1));
            }
            if(maxLength==s.length())
                return s.length();
        }
        return maxLength;
    }
}
//Time Complexity = O(n*n) , space complexity = o(256) = o(1)

        return max;
    }
}
