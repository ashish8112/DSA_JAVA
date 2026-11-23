class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        boolean [] visited = new boolean [adj.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0]=true;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) // O(N) 
        {
            Integer node = q.poll();
            ans.add(node);
            for(int i=0;i<adj.get(node).size();i++) // O(2E)
            {
                Integer vertex = adj.get(node).get(i);
                if(!visited[vertex])
                {
                    q.offer(vertex);
                    visited[vertex]=true;
                }
            }
        }
        return ans;
    }
}
// Time complexity : O(N+2E)
// Space complexity : O(3N) -> O(N)
