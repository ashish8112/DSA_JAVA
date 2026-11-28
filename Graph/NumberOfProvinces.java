class SolutionDFS {
    void dfs(int node,boolean[]visited,int[][]isConnected) // O(V*V) because in each row we have iterate every index
    {
        visited[node]=true;
        for(int i=0;i<isConnected[node].length;i++) 
        {
            if(isConnected[node][i]==1 && visited[i]!=true)
            dfs(i,visited,isConnected);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean [] visited = new boolean [isConnected.length];
        int count = 0;
        for(int i=0;i<isConnected.length;i++)
        {
            if(!visited[i]){
                count++;
                dfs(i,visited,isConnected);
            }
        }
        return count;
    }
}
// Time Complexity : O(V*V) where V = N = O(N^2)
// Space Complexity : O(V) + O(V) dfs recursion = O(V)= > O(N) 

class SolutionBFS {
    void bfs (int vertex, boolean [] vis , int [][] isConnected)
    {
        Queue<Integer> q = new LinkedList<>();
        q.offer(vertex);
        vis[node]=true;
        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int i=0;i<isConnected[node].length;i++)
            {
                if(isConnected[node][i]==1 && !vis[i])
                {
                    q.offer(i);
                    vis[i]=true;
                }
            }

        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean [] vis = new boolean [isConnected.length];
        int count =0;
        for(int i=0;i<isConnected.length;i++)
        {
            if(!vis[i])
            {
                count++;
                bfs(i,vis,isConnected);
            }
        }
        return count;
    }
}
// Same Time and space complexity like above 
