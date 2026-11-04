class Solution {
    void bottomView(Node root,Map<Integer,int []>map,int depth,int col)
    {
        if(root==null)return;
        int [] curr = map.get(col); // if not there curr will point to null which is acceptable 
        if(curr==null || curr[0]<=depth)
        map.put(col, new int[]{depth, root.data});
        bottomView(root.left,map,depth+1,col-1);
        bottomView(root.right,map,depth+1,col+1);
    }
    public ArrayList<Integer> bottomView(Node root) {
        Map<Integer,int []>map = new TreeMap<>();
        bottomView(root,map,0,0);
        ArrayList<Integer>list = new ArrayList<>();
        for(int i :map.keySet())
        {
            list.add(map.get(i)[1]);
        }
        return list;
    }
}

// Time complexity = O(N log k) 
// Space Complexity = O(K+h)
