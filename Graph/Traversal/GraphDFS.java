class Solution {
    public void traverse(int node,ArrayList<ArrayList<Integer>>adj,boolean[] visited,ArrayList<Integer>ans)
    {
        visited[node]=true;
        ans.add(node);
        for(int i:adj.get(node))
        {
            if(!visited[i])
            traverse(i,adj,visited,ans);
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean [] visited = new boolean [adj.size()];
        ArrayList<Integer>ans  = new ArrayList<>();
        traverse(0,adj,visited,ans);
        return ans;
    }
}

// Time Complexity : O(V+2E) = O(V+E) , v for vertex
// Space complexity : O(V+V) , one V for visited array and one for V for recursion in worst case where chain is largest
