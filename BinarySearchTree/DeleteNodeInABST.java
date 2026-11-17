class Solution {
    public TreeNode delete(TreeNode root)
    {
        if(root.left==null || root.right==null)
        {
            if(root.left!=null)return root.left;
            return root.right;
        }
        TreeNode temp = root.left;
        while(temp.right!=null)
        temp=temp.right;
        temp.right=root.right;
        return root.left;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        return root;
        if(root.val==key)
        return delete(root);
        if(root.val>key)
        root.left=deleteNode(root.left,key);
        else
        root.right=deleteNode(root.right,key);
        return root;
    }
}
// Time complexity : O(h) 
// Space complexity : O(h) 

// in case skewed tree means sare node ek hi side  but in search of bst tree height tak hi search karna padta hain so o(h) honga worst 
// even in skewed tree kyuki height hi skweed tree ka honga not log n , because log n is for balanced tree


/*
Pattern: BST Delete (Reconnect without losing subtrees)

Trigger: BST se node hatana hai, BST property bani rehni chahiye.

Template:
    delete(node):
        if (node.left == null || node.right == null)
            return node.left != null ? node.left : node.right;   // 0 ya 1 child
        max = node.left; while (max.right != null) max = max.right;
        max.right = node.right;          // right subtree left ke max ke neeche
        return node.left;

Key Insights:
1) 0 ya 1 child: kuch mat chhedo, bacha hua child return karo.
   Child ka existing subtree overwrite kiya to wo kho jaata hai.
2) 2 children: left ki har value < right ki har value.
   Left ka MAX node (right-most) ka right hamesha null hota hai,
   wahi safe jagah hai right subtree lagane ki.
   (Mirror: right ka MIN node ka left null, wahan left subtree lagao.)
3) Ye tareeka height badha sakta hai. Alternative: value ko inorder
   successor se replace karo, phir successor ko right subtree se delete karo.

Complexity: Time O(h), Space O(h)
*/
