```java
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
    public int height(TreeNode root)
    {
        if(root==null)
        return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(left==-1||right==-1)
        return -1;
        if(Math.abs(left-right)>1)
        return -1;
        return 1+Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        int result = height(root);
        if(result==-1)
        return false;
        return true; // or instead of these four line return height(root)!=-1;
    }
}

//Time Complexity = O(n) because it will go each node 
//Space Complexity = O(h) can be O(n) for skew tree


/*
Pattern: Bottom-Up Recursion with Sentinel Return
         (return value me do information pack karna)

Trigger: Har subtree pe koi condition check karni hai, aur ek baar fail
         hone pe poora answer fail ho jaata hai (early exit chahiye).

Template:
    int height(TreeNode node) {
        if (node == null) return 0;

        int left  = height(node.left);
        int right = height(node.right);

        if (left == -1 || right == -1) return -1;      // neeche se aaya failure
        if (Math.abs(left - right) > 1) return -1;     // yahan failure mila

        return 1 + Math.max(left, right);              // sab theek, height do
    }

    return height(root) != -1;

Key Insights:
1) -1 sentinel safe hai kyunki valid height kabhi negative nahi hoti.
   Isliye ek hi return slot me "height" aur "fail hua kya" dono aa gaye.
2) Naive approach: har node pe alag se height() call karo -> O(n^2).
   Yahan ek hi traversal me height bhi mil rahi hai aur check bhi ho raha hai -> O(n).
3) Check ka ORDER matter karta hai: pehle -1 propagation, phir abs difference.
   Ulta karne pe -1 ke saath arithmetic ho jaayegi.
4) Diameter me int[] accumulator chahiye tha, yahan nahi. Farak:
   - extra info ek FLAG hai   -> sentinel se return me pack karo
   - extra info ek RUNNING MAX -> alag accumulator chahiye

Complexity: Time O(n)  - har node ek baar
            Space O(h) - skewed O(n), balanced O(log n)
*/
