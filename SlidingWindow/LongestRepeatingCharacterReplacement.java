//Real Working Formula = right - left + 1 - maxFreq <= k means windowLength - maxFreq of Character <= k 

class BruteSolution {  //Brute Appraoch or Naive Approach
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        for(int i=0;i<s.length();i++)
        {
            int [] freq = new int [26];
            int maxFreq =0;
            for(int j=i;j<s.length();j++)
            {
                char ch = s.charAt(j);
                freq[ch-'A']++;
                maxFreq=Math.max(maxFreq,freq[ch-'A']);
                int currentLength = j-i+1;
                if(currentLength-maxFreq<=k)
                maxLength=Math.max(maxLength,currentLength);
                else 
                break;
            }
        }
        return maxLength;
    }
}

//Time Complexity = O(n^2)
//Space Complexity = O(26) = O(1);

class BetterSolution { //Better Solution
    public int characterReplacement(String s, int k) {
        int maxLength =0;
        int maxFreq = 0;
        Map<Character,Integer>map= new HashMap<>();
        int left=0;
        int right=0;
        while (left<s.length()&&right<s.length())
        {
            int currentLength = right-left+1;
            char ch = s.charAt(right);
            map.putIfAbsent(ch,0);
            map.put(ch,map.get(ch)+1); // we can skip this and upper line of map and can write  ** map.put(ch,map.getOrDefault(ch,0)+1)
            maxFreq=Math.max(maxFreq,map.get(ch));
            while(currentLength-maxFreq>k)
            {
                maxFreq=0;
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
                currentLength=right-left+1;
                for(Character key : map.keySet())
                maxFreq=Math.max(maxFreq,map.get(key));
            }
            maxLength=Math.max(maxLength,currentLength);
            right++;
        }
        return maxLength;
    }
}

//Time Complexiy = O(n * 26) = O(n) because map can store only 26 UpperCase Alphabet as given in Question 
//Space Complexity = O(26) = O(1) 

class BetterSolutionV2 { //Better Solution With Map 
    public int characterReplacement(String s, int k) {
        int maxLength =0;
        int maxFreq = 0;
        int [] freqArray = new int [26];
        int left=0;
        int right=0;
        while (right<s.length()) //remove left check because left can't go forward of right.
        {
            int currentLength = right-left+1;
            char ch = s.charAt(right);
            freqArray[ch-'A']++;
            maxFreq=Math.max(maxFreq,freqArray[ch-'A']);
            while(currentLength-maxFreq>k)
            {
                maxFreq=0;
                char leftCh = s.charAt(left);
                freqArray[leftCh-'A']--;
                left++;
                currentLength=right-left+1;
                for(int i=0;i<26;i++)
                maxFreq=Math.max(maxFreq,freqArray[i]);
            }
            maxLength=Math.max(maxLength,currentLength);
            right++;
        }
        return maxLength;
    }
}

//Time complexity = O(n*26) = O(n)
//Space complexity = o(26) = o(1)

