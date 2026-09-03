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
class Solution { // Brute force
    public int index = 0;
    public TreeNode build(int start , int end,int [] preorder,int [] inorder)
    {
        if(start>end)
        return null;
        TreeNode root = new TreeNode (preorder[index]);
        for(int i=start;i<=end;i++)
        {
            if(root.val==inorder[i])
            {
                index++;
                root.left=build(start,i-1,preorder,inorder);
                root.right=build(i+1,end,preorder,inorder);
                break;
            }
        }
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder ) {
        index = 0;
        TreeNode root = build(0,preorder.length-1,preorder,inorder);
        return root;
    }
}

//Time Complexity = o(n * n ) because n for each node we are calling function recursion stack and n time for searching in order array 
//Space complexity = o (n) because n stack of recursion can be create for skew tree . 

//Idea - Traverse one by one in preorder these are node which will be root node at every subtree like 0th preorder is root of whole tree 1st index of preorder will be root node of left 
//subtree if exist or it be  will be root node of right subtree, increment it always to get root node for subtree also. 
//the root node which we get from preorder search it into inorder left side of inorder will be left subtree and right side of inorder will be right subtree
// at every level either in left or right make index value of preorder as a root node of that subtree and again search it that root in inorder and call recurisvely left side of inorder for 
//left, maintain the start and end of subtree at each level from inorder so when start > end means that root points to null while calling both side at this point don't increment
// index global pointer at that point because here we have set our node to null either left or right didn't create any root node with index 
//Note when start == end means there are only one node increment the index for next root node for any subtree but then this  start == end call left or right side it will return null 
//because start,start-1 why start -1 because we will get root node at start index only because we know that inorder and preorder values are same and size are same also and to create 
// node (root) at that level we have to find index from start to end only so there is only 1 element so we will get that root index in preorder at start so as we know we have to call 
//for left subtree (start , index where we got in inorder -1 ) => (start , index where got in inorder is same as start so start -1) and for right subtree ( start +1 , end ) 
// and start was equall to end so now start is greater than end 

//We can optimmize it using hashmap and store values and index of inorder in map to lookup the index at o(1) for calling left and right subtree see below code 

class Solution { // Optimal Approach 
    public int index = 0;
    Map <Integer,Integer> map = new HashMap<>();
    public TreeNode build(int start , int end,int [] preorder)
    {
        if(start>end)
        return null;
        TreeNode root = new TreeNode (preorder[index]);
        int rootPositionInInorder = map.get(preorder[index]);
        index++;
        root.left = build(start,rootPositionInInorder-1,preorder);
        root.right = build(rootPositionInInorder+1,end,preorder);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder ) {
        index = 0;
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);
        TreeNode root = build(0,preorder.length-1,preorder);
        return root;
    }
}

//Time complexity = o(n) 
//Space complexity = o(n+h) = o(n) // one for map and another for recursion stack

/*
Pattern: Tree Construction from Two Traversals (Preorder + Inorder)
Trigger: Do traversal arrays se unique binary tree banana ho
Template:
    map = {inorder value -> index}
    index = 0   // global pointer into preorder
    build(start, end):
        if (start > end) return null
        root = new TreeNode(preorder[index])
        pos = map.get(preorder[index])
        index++                              // left call se PEHLE
        root.left  = build(start, pos-1)
        root.right = build(pos+1, end)
        return root
Key Insights:
1) Preorder ka current element hamesha current subtree ka root hai
2) Inorder mein us root ke LEFT ka sab left subtree, RIGHT ka sab right subtree
3) index ko CALCULATE mat karo sequentially consume karo. Recursion ka order (root→left→right) preorder ke order se exactly match karta hai, isliye pointer khud sync rehta hai
4) index++ left call se pehle hona zaroori — warna dono children same index padhenge
5) start > end matlab empty subtree → null, aur us call mein index touch nahi hota
6) HashMap se inorder position O(1) — bina iske har call linear search karti aur O(n²) ban jaata
7) buildTree mein index aur map reset karna zaroori — judge multiple test cases same object pe chalata hai
Complexity: Brute  Time O(n²), Space O(h)
            Optimal Time O(n), Space O(n) map + O(h) stack
*/
