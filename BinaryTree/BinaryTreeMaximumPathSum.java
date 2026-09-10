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
class Solution { //Think of Kadane's Algorithm if sum was smaller than 0 means negative convert it into 0 that's what we do here if left or right subtree give negative convert 0, we don't need that subtree
    public int maxPath(TreeNode root,int [] maxSum)
    {
        if(root==null)
        return 0;
        int left = maxPath(root.left,maxSum);
        int right = maxPath(root.right,maxSum);
        if(left<0)
        left=0;
        if(right<0)
        right=0; // instead of all above four line -> int left = Math.max(0,maxPath(root.left,maxSum)) and same for right 
        maxSum[0] = Math.max(maxSum[0],root.val+left+right);
        return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        int [] maxSum = {Integer.MIN_VALUE};
        maxPath(root,maxSum);
        return maxSum[0];
    }
}

//Time complexity = O(n) 
//Space complexity = O(h) 


/*
Pattern: Bottom-Up with Accumulator + Negative Clamp (Kadane on Tree)

Trigger: Har node pe koi optimal value banti hai, values NEGATIVE ho sakti hain,
         aur global max chahiye. Path root se guzarna zaroori nahi.

Template:
    int maxPath(TreeNode node, int[] maxSum) {
        if (node == null) return 0;

        int left  = Math.max(0, maxPath(node.left,  maxSum));   // negative? chhod do
        int right = Math.max(0, maxPath(node.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], node.val + left + right);  // MUD gaya path
        return node.val + Math.max(left, right);                   // parent ko ek taraf
    }

    int[] maxSum = {Integer.MIN_VALUE};

Key Insights:
1) Yahi Diameter (LC 543) ka shape hai. Fark sirf itna:
   Diameter -> edges gine, heights hamesha >= 0
   Path Sum -> values jodi, negative aa sakti hain -> clamp chahiye

2) Kadane ka hi idea hai: negative prefix kabhi kisi bade sum me
   madad nahi kar sakta, isliye use hamesha chhoda ja sakta hai.
   Array me ek line, tree me har node pe DO taraf.

3) left = 0 ka matlab "child ki value 0 hai" NAHI hai.
   Matlab hai "us rasta pe gaye hi nahi".

4) Clamp aur MIN_VALUE alag cheezein hain, contradiction nahi:
   clamp     -> child ka RASTA optional hai, chhod sakte ho
   MIN_VALUE -> KHUD node chhod nahi sakte, path me min 1 node zaroori
   Isliye [-3] ka answer -3 hai, 0 nahi.

Complexity: Time O(n), Space O(h) -> skewed O(n), balanced O(log n)
*/
