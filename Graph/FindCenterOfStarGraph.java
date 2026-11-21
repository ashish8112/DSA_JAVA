class BruteSolution {
    public int findCenter(int[][] edges) {
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<edges.length+2;i++) // edges = n-1, nodes 1..n, size = n+1 = edges.length+2
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

class BetterSolution { // Instead of list we have used array 
    public int findCenter(int[][] edges) {
        int [] degree = new int [edges.length+2];
        for(int i=0;i<edges.length;i++)
        {
            int start = edges[i][0];
            int end = edges[i][1];
            degree[start]++;
            degree[end]++;
        }
        int max = Integer.MIN_VALUE;
        int ans = 1;
        for(int i=0;i<degree.length;i++)
        {
            if(max<degree[i])
            {
                max=degree[i];
                ans=i;
            }
        }
        return ans;
    }
}
// Time complexity : O(N)
// Space complexity : O(N)

class OptimalSolution {
    public int findCenter(int[][] edges) {
        if(edges[0][0]==edges[1][0]||edges[0][0]==edges[1][1])
        return edges[0][0];
        return edges[0][1];
    }
}
// Approach in star graph where we have to find middle, in edges that center node will be always there 
// Time complexity : O(1)
// Space complexity : O(1)

/*
Pattern: Graph Degree / Structure Property (no traversal needed)

Trigger: Graph ka koi node uske connections ki GINTI se pehchana ja sake
         (center, judge, max network rank).

Versions:
    Brute:   adjacency list banao, sabse lambi list   -> O(n) / O(n)
    Better:  sirf int[] degree, har edge pe dono ++    -> O(n) / O(n)
    Optimal: star me center HAR edge me hai, pehle do edges ka
             common node hi center                     -> O(1) / O(1)

Key Insights:
1) n na diya ho to constraint se nikaalo: tree/star me edges = n - 1.
2) Sirf ginti chahiye to list mat banao, degree array kaafi hai.
3) Structure ki guarantee (star) se poora traversal bachta hai.

Complexity: Optimal Time O(1), Space O(1)
*/
