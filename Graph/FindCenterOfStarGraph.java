class BruteSolution {
    public int findCenter(int[][] edges) {
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<edges.length+2;i++)
        list.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int start = edges[i][0];
            int end = edges[i][1];
            list.get(start).add(end);
            list.get(end).add(start);
        }
        int max = Integer.MIN_VALUE;
        int ans = 1;
        for(int i=0;i<edges.length+2;i++)
        {
            if(max<list.get(i).size())
            {
                ans=i;
                max=list.get(i).size();
            }
        }
        return ans;
    }
}
// Time complexity : o(n)  -> // edges = n - 1, nodes 1..n, isliye size = n + 1 = edges.length + 2
// Space complexity : o(n)
