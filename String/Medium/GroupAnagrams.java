class Solution { //Brute force
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ga = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        String [] sorted = new String[strs.length];
        for(int i=0;i<strs.length;i++)
        {
            char [] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sorted[i]=new String(chars);
        }
        for(int i=0;i<strs.length;i++)
        {
            List<String> group = new ArrayList<>();
            if(!visited[i])
            {
            group.add(strs[i]);
            visited[i]=true;
            for(int j=i+1;j<strs.length;j++)
            {
                if(!visited[j]){ // if we remove this then also it is fine as it will check each element even it is visited but they would be not equall because if they were equal our outer loop will not have  eneterd till here.
                    if(sorted[i].equals(sorted[j]))
                    {
                        group.add(strs[j]);
                        visited[j]=true;
                    }
                }
            }
            ga.add(group);
            }
        }
        return ga;
    }
}

//Space Complexity = o(n) + o(n) + o(n) for innerArray List = o(3n)=> o(n) Space Complexity
//Time complexity = o(n * klogK) for sorting and k is length of each string  = o(nklogk) + o(n * n*k -k for eqaull checking ) = o(n klogk) + o(n^2 k) = o(n^2k)

class Solution { // Better Approach
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char [] ch = strs[i].toCharArray(); //O(k) k is length of that string
            Arrays.sort(ch); // k log k for sorting
            String sorted = new String(ch); // O(k) length space complexity 
            map.putIfAbsent(sorted,new ArrayList<>()); // O(1) time complexity because using key get, app/put, remove is o(1) for more check MAP/first.java code
            map.get(sorted).add(strs[i]); // O(1) 
        }
        for(String s : map.keySet()) // time complexity o(n) worst case when all string are unique so number of string is keys 
        {
            groupAnagrams.add(map.get(s)); // instead of this entire loop we can use return new ArrayList<>(map.values()); directly although we will have some time complexity o(n) but better for readibility better
        }
        return groupAnagrams;
    }
}
//Overall Time Complexity = o(n * klogk)+ o(n) = o(n klogk) 
//Space Complexity = o(n) for hashmap only loop char ch is temporary so wont be count in space complexity 


class Solution { // Optimal Solution 
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>(); // space complexity o(k*n) size of each string + 26 (but ignore constant)* n for n strings 
        for(int i=0;i<strs.length;i++) //o(n) tc
        {
            int [] freq = new int [26]; 
            for(int j=0;j<strs[i].length();j++) //o(k) tc 
            {
                freq[strs[i].charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder(); // o(1) always 52 size , waise ye temporary hain count nhi honga
            for(int j=0;j<26;j++) //o(1) always 26 iteration 
            {
                sb.append(freq[j]);
                sb.append("#"); //# because suppose freq a= 10 , b=0 aur c= 1 aur aggey 000 hain kyuki isme a ki 10 baar thaa abb dusrey string mein a =  1 b=0  c=1 aur ageey 000tha ..
            }                // to bina # ke  first string ka key = 1001000..... aur second string ka key = 101000.... same hain to same key hon jata jabki same nhi hai anagram so # use 
                            // taki differntiate 10#1#1#0#0.... and second key 1#0#1#0..... 
            String key = sb.toString();
            map.putIfAbsent(key,new ArrayList<>()); //tc o(1)
            map.get(key).add(strs[i]); // tc o(1) 
        }
        return new ArrayList<>(map.values()); // tc o(n) 
    }
}
//Space Complexity = o(k*n) 
// TIme complexity = o(n*k) k for inner loop 
