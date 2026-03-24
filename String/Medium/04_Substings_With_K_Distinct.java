class Solution {
    public int countSubstr(String s, int k) {
        int countSubstr=0;
        
        for(int i=0;i<s.length();i++)
        {
            int count =0;
            int [] freq = new int [128];
            for(int j=i;j<s.length();j++)
            {
               if(freq[s.charAt(j)]==0)//It checks either occurence of current element is first time or not 
               {
               count++;
               freq[s.charAt(j)]=1;//it updates the value of current element so next time it comes it  doesn't count as distinct.
               }
               if(count ==k)
               countSubstr++;
               else if(count>k)
               break;
            }
        }
        return countSubstr;
    }
}
