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
class SolutionRecursive { //using recursion
     public static List<Integer> traverse(TreeNode root,List<Integer> list)
    {
        if(root==null)
        return list;
        traverse(root.left,list);
        traverse (root.right,list);
        list.add(root.val);
        return list;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        return list;
    }
}

//Time Complexity = o(n);
//Space Compelxity = o(h);

class SolutionTwoStack { //Using two stack 
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
        return new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        Stack<Integer>result = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode temp = stack.pop();
            result.push(temp.val);
            if(temp.left!=null)stack.push(temp.left);
            if(temp.right!=null)stack.push(temp.right);
        }
        while(!result.isEmpty())
        list.add(result.pop());
        return list;
    }
}

//Time Complexity = o(n+n) = o(n) 
//Space Complexity = O(n) for result stack + o(h) for main stack = O(n+h) = o(n)

class Solution { //  using stack with root->right->left trick and then reverse and it is similar to upper one instead of adding to stack we directly adding to list and reversing (stack.pop())
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer>list = new ArrayList<>();
        if(root!=null)
        stack.push(root);
        while(!stack.isEmpty())
        {
            root=stack.pop();
            list.add(root.val);
            if(root.left!=null)stack.push(root.left);
            if(root.right!=null)stack.push(root.right);
        }
        int low=0;
        int high = list.size()-1;
        while(low<high)
        {
            int temp = list.get(low);
            list.set(low,list.get(high));
            list.set(high,temp);
            low++;
            high--;
        }
        return list;
    }
}

//Time complexity = o(n+n) = o(n)
//Space complexity = o(h) 
