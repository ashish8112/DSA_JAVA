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
