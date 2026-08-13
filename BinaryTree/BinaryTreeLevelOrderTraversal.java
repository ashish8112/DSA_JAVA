/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */ 
class Solution { //Optimal
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        List<List<Integer>>ans = new ArrayList<>();
        if(root==null)
        return ans;
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer>list = new ArrayList<>();
            int max = q.size();
            for(int i=0;i<max;i++)
            {
            TreeNode l = q.remove();
            list.add(l.val);
            if(l.left!=null)q.add(l.left);
            if(l.right!=null)q.add(l.right);
            }
           ans.add(list);
        }
        return ans;
    }
}

//Note this question is related to BFS so for bfs always use queue because bfs can be solved using stack so with recursion but it will complex
//reason stack follow LIFO which give dfs and for bfs we need fifo 
