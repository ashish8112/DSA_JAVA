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
    public int maxDiameter(TreeNode root,int [] max)
    {
        if(root==null)
        return 0;
        int left = maxDiameter(root.left,max);
        int right = maxDiameter(root.right,max);
      //left + right specific node ka total path length hain
        max[0]=Math.max(left+right,max[0]);
        return 1+Math.max(left,right); //height ek sidhi line honti hain jo maximum hain but diameter kisi node ka ye honta hain uske leftsbutree ki depth(means maximum length ya height keh 
                                      //lo aur rightsubtree ka maximum depth or height so diameter honga root = leftSubtree height + rightSubtree height but we need maximum that's why
                    //we are comparing and we are returning height of that node so that parent of that node will get maximumHeightorDepth to find diameter, if we return diameter 
                    //so that is not Depth or height of left or right subtree so we have to store it seprate and accumulate it entire the process.
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int [] max = {0};
        maxDiameter(root,max);
        return max[0];
    }
}

//Time Complexity = O(n) // every node we will traverse
// Space Complexity = O(h)   recursion stack
//   skewed tree -> h = n      -> O(n)   worst case
//   balanced tree -> h = log n  -> O(log n)

/*
Pattern: Bottom-Up Recursion with Side Accumulator
         (return value != answer value)

Trigger: Har node pe koi candidate answer banta hai aur global max chahiye,
         par parent ko us candidate ki zaroorat nahi - use kuch aur chahiye.

Template:
    int helper(TreeNode node, int[] acc) {
        if (node == null) return 0;
        int left  = helper(node.left,  acc);
        int right = helper(node.right, acc);

        acc[0] = Math.max(acc[0], left + right);   // CANDIDATE - pehle record
        return 1 + Math.max(left, right);          // PARENT ko kya chahiye
    }

Key Insights:

1) Do alag cheezein hain, isliye confusion hoti hai:

   left + right              = path jo is node pe MUD raha hai
                               left me neeche, wapas is node tak, phir right me neeche
                               DO taraf

   1 + max(left, right)      = height, matlab is node se SIRF NEECHE
                               sabse door node tak ki distance
                               EK taraf, koi mudna nahi

2) Parent ko left+right kyun nahi de sakte?

   Jo path is node pe mud gaya, wo parent tak pahunch hi nahi sakta.
   Parent ke through jaane ke liye path ko is node se UPAR nikalna hoga,
   aur upar nikalne wala path yahan mud nahi sakta - path ek hi baar
   mudta hai, aur wo jagah parent hogi ya uske upar.

   Isliye parent ko sirf ek seedhi tang chahiye = height.
   Jo mud gaya wo yahin khatam - use acc[0] me daal do.

3) Path root se guzarna zaroori nahi. Isliye har node candidate hai,
   sirf root nahi.

4) acc[0] ka update return se PEHLE. Return ke baad likha to
   wo line kabhi chalegi hi nahi.

5) int[] acc use karo, instance variable nahi -
   multiple test cases pe manually reset karna nahi padta.

6) Yahi shape aage bhi aata hai: Max Path Sum (LC 124),
   Longest Univalue Path, Balanced Tree (LC 110).
   Sirf candidate ka formula badalta hai, structure same rehta hai.

Complexity: Time O(n)  - har node exactly ek baar
            Space O(h) - skewed O(n), balanced O(log n)
*/
