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
    public int maxDep(TreeNode root, int count){
        if(root==null)
        return count-1;
        int leftTree = maxDep(root.left,count+1);
        int rightTree = maxDep(root.right,count+1);
        return Math.max(leftTree,rightTree);
    }
    public int maxDepth(TreeNode root) {
        return maxDep(root,1);
    }
}

//Time Complexity = o(n)
//Space complexity = o(h)
