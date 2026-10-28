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
class BetterSolution {
    public int findBottomLeftValue(TreeNode root) { // In 2 pass 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            count++;
        }
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            count--;
            for(int i=0;i<size;i++)
            {
                
                TreeNode node = q.poll();
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
                if(count==0)
                return node.val;
            }
        }
        return -1;
    }
}
// Time Complexity - O(N)
// Space Complexity - O(W)
