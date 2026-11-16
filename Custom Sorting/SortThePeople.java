class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map = new TreeMap<>();
        for(int i=0;i<names.length;i++) // O(N)
        map.put(heights[i],names[i]); //O(log n) -> O(N logN)
        String [] ans = new String [names.length];
        int i = ans.length-1;
        for(Map.Entry<Integer,String> entry: map.entrySet())
        {
            ans[i--]=entry.getValue();
        }
        return ans;
    }
}
// Time Complexity = O(N log N)
// Space Complexity = O(N)

class UsingArraySolution {
    public String[] sortPeople(String[] names, int[] heights) {
        int [] [] people = new int [names.length][2];
        for(int i=0;i<names.length;i++)
        people[i]=new int [] {heights[i],i};
        Arrays.sort(people,(a,b)->b[0]-a[0]);
        String[] sortPeople = new String [names.length];
        for(int i=0;i<names.length;i++)
        sortPeople[i]=names[people[i][1]];
        return sortPeople;
    }
}

// Time Complexity = O(N log N)
// Space Complexity = O(N)
