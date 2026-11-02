/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
} */

class Solution { // Brute 
    void traversal(Node root,Map<Integer,List<int[]>>map,int row,int column)
    {
        if(root==null)
        return;
        map.putIfAbsent(column,new ArrayList<>());
        map.get(column).add(new int [] {row,root.data});
        traversal(root.left,  map, row+1, column-1);
        traversal(root.right, map, row+1, column+1);
    }
    public ArrayList<Integer> topView(Node root) {
        Map<Integer,List<int[]>>map = new TreeMap<>();
        traversal(root,map,0,0);
        ArrayList<Integer>list = new ArrayList<>();
        for(Map.Entry<Integer,List<int []>> e : map.entrySet())
        {
            List<int []> col = e.getValue();
            Collections.sort(col,(a,b)->{
                return Integer.compare(a[0],b[0]);
            });
            for(int [] node: col)
                   {
                       list.add(node[1]);
                       break;
                   }
        }
         return list;         
    }
}

// Time Complexity : O(n log n ) 
// Space complexity = O(n) 

class BetterSolution {  //Note we can remove list in map.
    void traversal(Node root,Map<Integer,List<int[]>>map,int row,int column)
    {
        if(root==null)
        return;
        map.putIfAbsent(column,new ArrayList<>());
        if(map.get(column).size()==0)
        {
        map.get(column).add(new int [] {row,root.data});
        }
        else{
            if(map.get(column).get(0)[0]>row)
            {
                map.get(column).get(0)[0]=row;
                map.get(column).get(0)[1]=root.data;
            }
        }
        traversal(root.left,  map, row+1, column-1);
        traversal(root.right, map, row+1, column+1);
    }
    public ArrayList<Integer> topView(Node root) {
        Map<Integer,List<int[]>>map = new TreeMap<>();
        traversal(root,map,0,0);
        ArrayList<Integer>list = new ArrayList<>();
        for(Map.Entry<Integer,List<int []>> e : map.entrySet())
        {
            List<int []> col = e.getValue();
            list.add(col.get(0)[1]);
        }
         return list;         
    }
}

// Time Complexity : O(n log k ) , log k because of Treemap at every node
// Space Complexity : O(h+k)


class BetterSolutionV2 {
    void traversal(Node root,Map<Integer,int []>map,int row,int column)
    {
        if(root==null)
        return;
        int [] curr = map.get(column);
        if(curr==null||row<curr[0])
            map.put(column,new int [] {row,root.data});
        traversal(root.left,  map, row+1, column-1);
        traversal(root.right, map, row+1, column+1);
    }
    public ArrayList<Integer> topView(Node root) {
        Map<Integer,int[]>map = new TreeMap<>();
        traversal(root,map,0,0);
        ArrayList<Integer>list = new ArrayList<>();
        for(Map.Entry<Integer,int [] > e : map.entrySet())
        {
            int [] curr = e.getValue();
            list.add(curr[1]);
        }
         return list;         
    }
}

// Time Complexity : O(n log k ) , log k because of Treemap at every node
// Space Complexity : O(h+k)
