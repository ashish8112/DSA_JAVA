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
    void preOrder(TreeNode root,List<Integer>list)
    {
        if(root==null)
        {
            list.add(null);
            return ;
        }
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null)
        return p==q;
        List<Integer>list = new ArrayList<>();
        List<Integer>list2=  new ArrayList<>();
        preOrder(p,list);
        preOrder(q,list2);
        if(list.size()!=list2.size())
        return false;
        for(int i=0;i<list.size();i++)
        {
            if (!Objects.equals(list.get(i), list2.get(i)))  //under the hood will get check values if it is not null and if one is null and another is not null then also it will return false
            return false;
        }
        return true;
    }
}

//Time Complexity = O(n+n+n) n for p , n for q and n for list => O(n)
//Space complexity = O(h+n+n) h for p or q and 2n for list = > O(n)

class OptimalSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null) // for early return 
        return p==q;
        if(p.val!=q.val)
        return false;
        boolean left = isSameTree(p.left,q.left);
        if(left==false)
        return false;
        boolean right = isSameTree(p.right,q.right);
        if(right==false)
        return false;
        return true; // or isSameTree(p.left,q.left) && isSameTree(p.right,q.right) for all 7 lines from boolean left
    }
}

//Time Complexity = O(n) 
//Space Complexity = O(h)

/*
Pattern: Simultaneous Recursion on Two Trees

Trigger: Do trees ko structurally compare karna ho - same, symmetric,
         subtree check, merge two trees.

Template:
    boolean solve(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;   // dono null -> true, ek null -> false
        if (p.val != q.val) return false;
        return solve(p.left, q.left) && solve(p.right, q.right);
    }

Key Insights:
1) Signature me DO nodes lo. Ek saath traverse karo, list banake compare mat karo -
   list wala O(n) space leta hai, ye O(h) leta hai.
2) p == null || q == null -> return p == q
   Ek line me dono cases: dono null (true), ek null (false).
   Yahan == sahi hai kyunki REFERENCE compare ho raha hai, value nahi.
3) && short-circuit karta hai - left false hua to right ki recursion
   chalegi hi nahi. Manual if-check ki zaroorat nahi.
4) Symmetric Tree (LC 101) yahi template hai, bas cross se call karo:
   solve(p.left, q.right) && solve(p.right, q.left)

Complexity: Time O(n)  - worst case dono trees poore traverse
            Space O(h) - sirf recursion stack, koi list nahi
*/
