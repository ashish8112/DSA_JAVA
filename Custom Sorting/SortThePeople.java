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
