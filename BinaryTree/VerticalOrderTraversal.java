class List2DSolution {
    public void number(TreeNode root,int row,int col, Map<Integer,List<List<Integer>>>map)
    {
        if(root==null)
        return;
        map.putIfAbsent(col,new ArrayList<>());
        List<Integer>list = new ArrayList<>();
        list.add(row);
        list.add(root.val);
        map.get(col).add(list);
        number(root.left,row+1,col-1,map);
        number(root.right,row+1,col+1,map);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null)
        return new ArrayList<>();
        Map<Integer,List<List<Integer>>>map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        number(root,0,0,map);
        for(int i:map.keySet())
        {
            Collections.sort(map.get(i),(a,b)->{
                if(a.get(0).equals(b.get(0)))
                return Integer.compare(a.get(1),b.get(1));
                return Integer.compare(a.get(0),b.get(0));
            });
            List<Integer>list = new ArrayList<>();
            for(int j=0;j<map.get(i).size();j++)
            list.add(map.get(i).get(j).get(1));
            ans.add(list);
        }
        return ans;
    }
}

//Time Complexity : o(n) + o(horizontal Distance) + nlogn +  


class ListWithArraySolution {
    public void number(TreeNode root,int row,int col, Map<Integer,List<int []>>map)
    {
        if(root==null)
        return;
        map.putIfAbsent(col,new ArrayList<>());
        map.get(col).add(new int [] {row,root.val});
        number(root.left,row+1,col-1,map);
        number(root.right,row+1,col+1,map);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null)
        return new ArrayList<>();
        Map<Integer,List<int []>>map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        number(root,0,0,map);
        for(int i:map.keySet())
        {
            Collections.sort(map.get(i),(a,b)->{
                if(a[0]==b[0])
                return Integer.compare(a[1],b[1]);
                return Integer.compare(a[0],b[0]);
            });
            List<Integer>list = new ArrayList<>();
            for(int j=0;j<map.get(i).size();j++)
            list.add(map.get(i).get(j)[1]);
            ans.add(list);
        }
        return ans;
    }
}


class MapEntrySetUsingArraySolution {
    public void number(TreeNode root,int row,int col, Map<Integer,List<int []>>map)
    {
        if(root==null)
        return;
        map.putIfAbsent(col,new ArrayList<>());
        map.get(col).add(new int [] {row,root.val});
        number(root.left,row+1,col-1,map);
        number(root.right,row+1,col+1,map);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null)
        return new ArrayList<>();
        Map<Integer,List<int []>>map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        number(root,0,0,map);
        for(Map.Entry<Integer,List<int [] >> e : map.entrySet())
        {
            List<int [] > col = e.getValue();
            Collections.sort(col,(a,b)->{ // or col.sort(....)
                if(a[0]==b[0])
                return Integer.compare(a[1],b[1]);
                return Integer.compare(a[0],b[0]);
            });
            List<Integer>list = new ArrayList<>();
            for(int [] node: col)
            list.add(node[1]);
            ans.add(list);
        }
        return ans;
    }


  /*
Pattern: Coordinate Collection + Multi-Level Sort

Trigger: Tree ke nodes ko position ke hisaab se group karna ho
         (vertical order, top view, bottom view, diagonal).

Template:
    dfs(node, row, col, map):
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, node.val});
        dfs(node.left,  row+1, col-1, map);
        dfs(node.right, row+1, col+1, map);

    // TreeMap se columns already sorted
    for (entry : map.entrySet()) {
        col.sort((a,b) -> a[0] != b[0] ? compare(a[0],b[0]) : compare(a[1],b[1]));
        // sirf values nikaalo
    }

Key Insights:
1) Tie-breaking teen level ka hai: col -> row -> value.
   col TreeMap sambhalta hai, row aur value comparator sambhalta hai.
2) Sirf col track karna kaafi nahi - row bina, same column ke alag levels
   mix ho jaate hain aur galat order aata hai.
3) int[] use karo List<Integer> nahi - na boxing, na object overhead.
   Aur a[0] == b[0] primitive pe safe hai; Integer pe .equals() chahiye hota.
4) entrySet() se ek hi lookup, keySet() + get() se do.
   TreeMap pe har get O(log k) hai, isliye yahan zyada matter karta hai.

Complexity: Time O(n log n) - sorting dominate karti hai
            Space O(n)
*/
}
