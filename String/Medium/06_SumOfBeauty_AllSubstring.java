class Solution {
    public int beautySum(String s) {
        int count =0;
        for(int i=0;i<s.length();i++)
        {
            int [] freq = new int [26];
            for(int j=i;j<s.length();j++)
            {
                freq[s.charAt(j)-'a']++;
                 int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int k=0;k<freq.length;k++)
            {
                if(freq[k]>max)
                max=freq[k];
                if(freq[k]<min&&freq[k]>0)
                min = freq[k];
            }
                // if(max-min>=1)no need because if max-min =0 it will added 0
                count+=max-min;
            }
        }
        return count;
    }
}

//we need to return sum of beauty suppose some have beauty 1 and sum have beauty 2 so add all not count beauty , it is some of beauty of substrings

/*Pattern: Incremental Frequency + Fixed Start Two Loop
Trigger: "all substrings", "frequency difference", "beauty"
         "sum/count over all substrings"

Template:
for(int i = 0; i < n; i++) {
    int[] freq = new int[26];     // Reseting for every i
    for(int j = i; j < n; j++) {
        freq[s.charAt(j)-'a']++;  // incrementally add karo
        // ab freq[] mein substring hai i to j ex aabcb -> for i =0 and j=0 which "a" checks beauty(fequency) for a then i =0 and j=1 which "aa" 
        //becuase first a makes freq[0]=1 and second time freq[0] = 2 now if i =0 and j=2 "aab" already freq[0]=2 and now freq[1]= 1 ;
        // O(26) mein max/min/answer nikalo for every step example for a , aa, aab , aabc 
    }
}  
  
Key Insights:
- freq[] ko i pe reset karo, j pe extend karo
- 3rd loop O(26) = O(1) time complexity
- count++ nahi, count += (max-min) — SUM chahiye, COUNT nahi

Complexity: Time O(n²), Space O(1) [26 fixed]
 This IS optimal for this problem*/
