/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean preOrder(TreeNode root,List<TreeNode>num,List<TreeNode>curr,TreeNode target)
    {
        if(root==null)
        return false;
        curr.add(root);
        if(root==target)
        {
            for(int i=0;i<curr.size();i++)
            num.add(curr.get(i));
            return false;
        }
        boolean left = preOrder(root.left,num,curr,target);
        if(left)
        return true;
        boolean right = preOrder(root.right,num,curr,target);
        if(right)
        return true;
        curr.removeLast();
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>nums1 = new ArrayList<>();
        List<TreeNode>nums2 = new ArrayList<>();
        preOrder(root,nums1,new ArrayList<>(),p);
        preOrder(root,nums2,new ArrayList<>(),q);
        for(int i=0;i<Math.min(nums1.size(),nums2.size());i++)
        {
            if(nums1.get(i).val!=nums2.get(i).val)
            return nums1.get(i-1);
        }
        if(nums1.size()<nums2.size())
        return nums1.get(nums1.size()-1);
        return nums2.get(nums2.size()-1);
    }
}

// Time complexity: O(N)
// Space complexity : O(N) 
