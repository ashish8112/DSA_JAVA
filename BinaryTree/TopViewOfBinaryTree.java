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
