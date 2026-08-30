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
    void invert(TreeNode root)
    {
        if(root==null)
        return;
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        invert(root.left);
        invert(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
}
//pattern swap left pointer and right pointer of each node
//Time Complexity = o(2n+1) because every node call itself two timee in handler method and +1 from main so final = o(n) 
//space complexity = same as above = o(n) 

//Instead of creating handler function we can do this below one 


class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
        return root;
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

//Same time and space complexity 
