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

class Solution { //Brute Force using stack
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode>stack = new Stack<>();// we will use stack to store nodes address/refernce
        List<Integer> list = new ArrayList<>();
        if(root!=null)
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null)stack.push(node.right);
            if(node.left!=null)stack.push(node.left);
        }
        return list;
    }
}

class Solution { //Optimal using recursion
    public static List<Integer> traverse(TreeNode root,List<Integer> list)
    {
        if(root==null)
        return list;
        list.add(root.val);
        traverse(root.left,list);
        traverse (root.right,list);
        return list;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer>list = new ArrayList<>();
      traverse(root,list);
      return list;
    }
}
