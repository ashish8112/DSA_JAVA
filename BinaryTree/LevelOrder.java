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
class Solution {
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