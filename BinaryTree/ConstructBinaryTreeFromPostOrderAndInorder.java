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
    public TreeNode build(int start, int end, int [] inorder,int [] postorder,int [] index){
        if(start>end)
        return null;
        int indexValue = postorder[index[0]];
        TreeNode root = new TreeNode(indexValue);
        for(int i=start;i<=end;i++)
        {
            if(root.val==inorder[i])
            {
                index[0]--;
                root.right=build(i+1,end,inorder,postorder,index);
                root.left=build(start,i-1,inorder,postorder,index);
                break;
            }
        }
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int [] index = {postorder.length-1};
        return build(0,inorder.length-1,inorder,postorder,index);
    }
}

//Time Complexity = o(n^2)
//Space complexity = o(n)

class Solution { //Optimal Approach
    public TreeNode build(int start, int end, int [] postorder,int [] index,Map<Integer,Integer>map){
        if(start>end)
        return null;
        int indexValue = postorder[index[0]];
        TreeNode root = new TreeNode(indexValue);
        int rootIndex = map.get(indexValue);
        index[0]--;
        root.right=build(rootIndex+1,end,postorder,index,map);
        root.left=build(start,rootIndex-1,postorder,index,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int [] index = {postorder.length-1};
         Map<Integer,Integer>map = new HashMap<>();
         for(int i=0;i<inorder.length;i++)
         map.put(inorder[i],i);
        return build(0,inorder.length-1,postorder,index,map);
    }
}

//Time complexity = o(n)
//Space complexity = o(n+h) = o(n)



/*
Pattern: Tree Construction from Two Traversals (Sequential Index Consumption)

Trigger: Inorder + (Preorder ya Postorder) diya ho, unique values, tree reconstruct karna ho.
         Inorder akela kaafi nahi — wo root ki position batata hai, identity nahi.

Template:
    int[] index = {postorder.length - 1};       // postorder: peeche se
    Map<Integer,Integer> map = inorder value -> index;

    build(start, end):
        if (start > end) return null;
        root = new TreeNode(postorder[index[0]]);
        rootIndex = map.get(root.val);
        index[0]--;
        root.right = build(rootIndex + 1, end);   // RIGHT pehle
        root.left  = build(start, rootIndex - 1);
        return root;

Key Insights:
1) Preorder root->left->right hai, isliye aage se consume + left pehle.
   Postorder left->right->root hai, ulta karo to root->right->left,
   isliye peeche se consume + RIGHT pehle. Order swap kiya to tree toot jaayega.
2) index ko calculate mat karo, consume karo. Recursion ka call order
   already traversal ke layout se match karta hai.
3) inorder sirf boundary (start/end) split karne ke liye hai.
   Root ki value hamesha doosre traversal se aati hai.
4) HashMap sirf O(n) linear search ko O(1) banata hai — logic same rehta hai.

Complexity:
    Brute:   Time O(n^2), Space O(h) -> worst O(n)
    Optimal: Time O(n),   Space O(n) map + O(h) stack = O(n)
*/
