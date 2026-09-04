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
    public TreeNode build(int start, int end, int [] inorder,int [] postorder,int [] index){
        if(start>end)
        return null;
        int indexValue = postorder[index[0]];
        TreeNode root = new TreeNode(indexValue);
        for(int i=start;i<=end;i++)
        {
            if(root.val==inorder[i])
            {
                index[0]--;
                root.right=build(i+1,end,inorder,postorder,index);
                root.left=build(start,i-1,inorder,postorder,index);
                break;
            }
        }
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int [] index = {postorder.length-1};
        return build(0,inorder.length-1,inorder,postorder,index);
    }
}

//Time Complexity = o(n^2)
//Space complexity = o(n)

class Solution { //Optimal Approach
    public TreeNode build(int start, int end, int [] postorder,int [] index,Map<Integer,Integer>map){
        if(start>end)
        return null;
        int indexValue = postorder[index[0]];
        TreeNode root = new TreeNode(indexValue);
        int rootIndex = map.get(indexValue);
        index[0]--;
        root.right=build(rootIndex+1,end,postorder,index,map);
        root.left=build(start,rootIndex-1,postorder,index,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int [] index = {postorder.length-1};
         Map<Integer,Integer>map = new HashMap<>();
         for(int i=0;i<inorder.length;i++)
         map.put(inorder[i],i);
        return build(0,inorder.length-1,postorder,index,map);
    }
}

//Time complexity = o(n)
//Space complexity = o(n+h) = o(n)
