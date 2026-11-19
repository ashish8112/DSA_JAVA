class Solution {
    public void sum (TreeNode root,List<List<Integer>>ans , List<Integer>current,int targetSum,int sum)
    {
        if(root==null)
        return;
        if(root.left==null && root.right==null)
        {
            current.add(root.val);
            sum+=root.val;
            if(sum==targetSum)
            ans.add(new ArrayList<>(current)); // time complexity o(size of list)
            current.removeLast();
            return;
        }
        current.add(root.val);
        sum+=root.val;
        sum(root.left,ans,current,targetSum,sum);
        sum(root.right,ans,current,targetSum,sum);
        current.removeLast();
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
        return new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();
        sum(root,ans,new ArrayList<>(),targetSum,0);
        return ans;
    }
}
// Time:  O(n) traversal + har matching leaf pe path copy O(h)
//        = O(n * h) zyada se zyada
//        Worst O(n^2): bahut leaves + deep leaves (caterpillar shape), sab paths match targetsum se 
//        Skewed tree me sirf 1 leaf hai, isliye wahan O(n) hi hai
// Space: O(h) recursion + current list. Skewed me h = n -> O(n)


class CleanSolution { // same solution of above just cleaned duplicate lines 
    public void sum (TreeNode root,List<List<Integer>>ans , List<Integer>current,int targetSum,int sum)
    {
        if(root==null)
        return;
        current.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right==null)
        {
            
            if(sum==targetSum)
            ans.add(new ArrayList<>(current));
        }
        else{
        sum(root.left,ans,current,targetSum,sum);
        sum(root.right,ans,current,targetSum,sum);
        }
        current.removeLast();
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
        return new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();
        sum(root,ans,new ArrayList<>(),targetSum,0);
        return ans;
    }
}
