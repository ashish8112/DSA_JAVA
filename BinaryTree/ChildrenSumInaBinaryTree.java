class Solution {
        int [] check (Node root)
        {
            if(root==null)
            return new int []{0,1};
            if(root.left==null && root.right == null)
            return new int [] {root.data,1};
            int [] left = check (root.left);
            int [] right = check(root.right);
            if(left[1]==0||right[1]==0)
            return new int [] {0,0};
            if(root.data!=(left[0]+right[0]))
            return new int [] {0,0};
            return new int [] {root.data,1};
        }
    public boolean isSumProperty(Node root) {
        int [] check = check(root);
                if(check[1]==1)
                return true;
                return false;
    }
}
