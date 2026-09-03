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
class Solution { // Brute force
    public int index = 0;
    public TreeNode build(int start , int end,int [] preorder,int [] inorder)
    {
        if(start>end)
        return null;
        TreeNode root = new TreeNode (preorder[index]);
        for(int i=start;i<=end;i++)
        {
            if(root.val==inorder[i])
            {
                index++;
                root.left=build(start,i-1,preorder,inorder);
                root.right=build(i+1,end,preorder,inorder);
                break;
            }
        }
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder ) {
        index = 0;
        TreeNode root = build(0,preorder.length-1,preorder,inorder);
        return root;
    }
}
