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
class OptimalSolutionBFS { //Optimal  using level order traversal  
    public int maxDepth(TreeNode root) {
          if(root==null)
          return 0;
          Queue<TreeNode>q = new LinkedList<>();
          q.add(root);
          int depth =0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.remove();
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            depth++;
        }
        return depth;
    }
}

//Time complexity = O(n)  // Best in case of left-skewed tree or right-skewed tree only one element will be there always  in queue if skewed tree then also optimal then recursion 
//Space complexity = O(w) where w is maximum width  

class OptimalSolutionTopToDown{
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

//Time Complexity = O(n)
//Space complexity = O(h)

class OptimalSolutionBottomToUp {
    public int maxDepth(TreeNode root) {
        if(root==null)
        return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1+Math.max(left,right);
    }
}
//Time Complexity = O(n) 
//Space complexity = O(h)
