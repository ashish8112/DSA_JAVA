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
class Solution { // Using LevelOrder traversal find the last node of that level
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
        return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.poll();
                if(i==size-1)
                list.add(temp.val);
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
        }
        return list;
    }
}

//Time complexity = O(n) 
// Space Complexity = O(w)
