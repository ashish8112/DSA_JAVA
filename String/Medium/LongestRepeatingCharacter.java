class Solution { //Brute Approach
    public int characterReplacement(String s, int k) {
        int maxLength =0;
        for(int i=0;i<s.length();i++)
        {
            int [] freq = new int [26];
            int maxFreq=0;
            for(int j=i;j<s.length();j++)
            {
                char ch = s.charAt(j);
                freq[ch-'A']++;
                maxFreq=Math.max(maxFreq,freq[ch-'A']);
                int changes = (j-i+1)-maxFreq;
                if(changes>k)
                break;
                maxLength = Math.max(maxLength,(j-i+1));
            }
        }
        return maxLength;
    }
}

//Time Complextiy : o(n^2)
//Space complexity = o(26);
