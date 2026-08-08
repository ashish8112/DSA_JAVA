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
class Solution { //using stack
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer>list = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null||!stack.isEmpty())
        {
            while(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            list.add(curr.val);
            curr=curr.right;
        }
        return list;
    }
}

class Solution { //using recursion
     public static List<Integer> traverse(TreeNode root,List<Integer> list)
    {
        if(root==null)
        return list;
        traverse(root.left,list);
        list.add(root.val);
        traverse (root.right,list);
        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        return list;
    }
}
