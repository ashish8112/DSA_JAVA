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
//Time Complexity = o(2n+1) because every node call it's children two time in handler method and +1 from main so final = o(n) 
//space complexity = o(h) but for skewed tree h=> o(n) and balanced tree = h = log n = O(log n) 
//Total frames created over time = 2n+1, but maximum frames alive at any moment = h+1 (path root to current node) depth/height
//That's why space is O(h), not O(n) always but final space complexity = O(n) in worst case (skewed tree)

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
