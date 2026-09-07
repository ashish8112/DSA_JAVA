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

class BetterSolutionV2 { //Better Solution Without Map 
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


class OptimalSolution {
    public int characterReplacement(String s, int k) {
        int maxLength =0; // we can remove this why read why we don't need to change maxFreq in below 
        int maxFreq = 0;
        int [] freqArray = new int [26];
        int left=0;
        int right=0;
        while (right<s.length())
        {
            int currentLength = right-left+1;
            char ch = s.charAt(right);
            freqArray[ch-'A']++;
            maxFreq=Math.max(maxFreq,freqArray[ch-'A']);
            if(currentLength-maxFreq>k)
            {
                char leftCh = s.charAt(left);
                freqArray[leftCh-'A']--;
                left++;
                currentLength = right-left+1;
            }
            maxLength=Math.max(maxLength,currentLength);
            right++;
        }
        return maxLength; // we can do s.lengt() - left;
    }
}
// We don't need to change maxFreq because 
// jab koi wrong substring mtlb replacement ke baad bhi condition question ka statify nhi karti hain k ke andar replacement wala to window 
// ka size na ghatao na badho bas slide kar do issey ye honga slide ke baad 2 condition hongey ya to kisi ki frequency badhi aur usne condition ko statisy kiya to sahi window ka size
// increase honga warna kisi ki frequency ghati phir wo purana max frequency yaha kaam karega kyuki slide ke wajah se pichla length slide se pehle jo thaa wahi same rahega aur 
// freqmax change nhi ki to wo bhi yahi same rahgea to ye bhi fail hi karega aur phir winodw slide honga maxLength mein difference honga hi nhi kuch maxLength tabhi badhega jab 
// frequency uss pichley wale maxFrequency se badhi to condition statisfy hua aur window ka size badha aur maxLength bhi badha 
// but ans will be always maximum window so we can return s.length()-left because yahi maximum window honga

/*
Pattern: Sliding Window with Stale Max Frequency (Non-Shrinking Window)

Trigger: "At most k changes/replacements/flips allowed, longest valid window chahiye."
         Window ke andar ek dominant element rakhna hai, baaki convert karne hain.

Template:
    int[] freq = new int[26];
    int left = 0, maxFreq = 0;
    for (int right = 0; right < s.length(); right++) {
        freq[s.charAt(right) - 'A']++;
        maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
        if ((right - left + 1) - maxFreq > k) {
            freq[s.charAt(left) - 'A']--;
            left++;
        }
    }
    return s.length() - left;

Key Insights:
1) changes = windowLength - maxFreq. Jo character sabse zyada hai use rehne do,
   baaki sab badalne padenge. Yahi poore problem ka core hai.
2) maxFreq ko kabhi ghatao mat. Stale value se galat answer nahi aata:
   stale maxFreq window ko CHHOTA hone se rokta hai, BADA hone nahi deta.
   Aur answer sirf bade hone se badhta hai.
3) Isliye inner while ki zaroorat nahi, simple if kaafi hai.
   Window kabhi shrink nahi hota - ya slide karta hai (same size) ya grow.
4) Window kabhi ghatta nahi, isliye maxLength track karna optional hai.
   Final answer = s.length() - left.
5) int[26] use karo, HashMap nahi. char auto-widen hota hai indexing ke liye,
   koi boxing/hashing overhead nahi.

Complexity: Time O(n)  - left aur right dono max n baar chalte hain
            Space O(26) = O(1)
*/
