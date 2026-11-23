class Solution {
    void dfs(int node,boolean[]visited,int[][]isConnected)
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
