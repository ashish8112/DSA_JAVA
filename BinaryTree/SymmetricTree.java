class SolutionQueue {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        //no need to check root
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty())
        {
            TreeNode a = q.poll();
            TreeNode b = q.poll();
            if(a==null && b==null)
            continue;
            if(a==null || b==null)
            return false;
            if(a.val!=b.val)
            return false;
            q.offer(a.left);
            q.offer(b.right);
            q.offer(a.right);
            q.offer(b.left);
        }
        return true;
    }
}


class SolutionRecursion {
    public boolean symmetric(TreeNode p , TreeNode q) // note p = left and q = right;
    {
       if(p==null || q==null)
       return p==q;
       if(p.val!=q.val)
       return false;
       return symmetric(p.left,q.right) && symmetric(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {

        if(root==null)
        return true;
        return symmetric(root.left,root.right);
    }
}
//Time complexity = O(n)
//Space complexity = O(h)
