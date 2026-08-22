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

class Solution { // Better
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
        return 0;
        int maxLength =1;
        int i=0;
        while (i<s.length())
        {
            Map<Character,Integer>map = new HashMap<>();
            int j=i;
            while(j<s.length()&&!map.containsKey(s.charAt(j)))
            {
                map.put(s.charAt(j),j++);
            }
            maxLength= Math.max(maxLength,j-i);
            if(j<s.length())
            {
                 i=map.get(s.charAt(j))+1;
            }
           
            else break;
        }
        return maxLength;
    }
}

//Time complexity = o(n) // confustion
//Space Complexity = o(n) // confusion 

class Solution { //Better 
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength=0;
        int left =0;//starting of window 
        for(int j=0;j<s.length();j++)
        {
            if(map.containsKey(s.charAt(j))&&map.get(s.charAt(j))>=left)//means it is in window
            {
                left=map.get(s.charAt(j))+1;// mmove left to new window 
            }
            map.put(s.charAt(j),j);
            maxLength= Math.max(maxLength,(j-left+1));
        }
            return maxLength;
    }
}
//Time complexity = o(n) 
// Space complexity = o(min(n,256)) 
