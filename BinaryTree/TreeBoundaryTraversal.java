class Solution {
    public void leftTree(Node root,ArrayList<Integer>list)
    {
        if(root==null||(root.left==null && root.right== null))
        return;
        list.add(root.data);
        leftTree(root.left,list);
        if(root.left==null)
        leftTree(root.right,list);
    }
    public void leafNode(Node root,ArrayList<Integer>list,Node head) 
    {
        if(root==null)
        return;
        leafNode(root.left,list,head);
        leafNode(root.right,list,head);
        if((root.left==null&&root.right==null) && root!=head)
        list.add(root.data);
        
    }
    public void rightTree(Node root,List<Integer>list) 
    {
        if(root==null||(root.right==null && root.left==null))
        return;
        list.addFirst(root.data);
        rightTree(root.right,list);
        if(root.right==null)
        rightTree(root.left,list);
    }
    public ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
        return list;
        List<Integer> reverseList = new  LinkedList<>();
        Node head = root;
        list.add(root.data);
        leftTree(root.left,list);
        leafNode(root,list,head);
        rightTree(root.right,reverseList);
        for(int value: reverseList)
        list.add(value);
        return list;
    }
}


/*
Pattern: Boundary Traversal (Teen hisson me toda)

Trigger: Tree ki boundary anti-clockwise chahiye - root, left boundary,
         leaves left-to-right, right boundary reversed.

Template:
    1. root add karo (agar leaf nahi hai)
    2. leftBoundary(root.left)  - leaves chhodke
    3. leaves(root)             - left se right
    4. rightBoundary(root.right) - leaves chhodke, addFirst se reversed

Key Insights:
1) Boundary MUDTI hai. "Left chalte raho" galat hai - left child ho to
   left jao, na ho to RIGHT jao. Right boundary me bilkul ulta.
       if (root.left != null) go left;
       else                   go right;

2) Left/right boundary me leaf pe RUK jao, add mat karo.
   Warna leaves do baar aayenge (boundary me bhi, leaves list me bhi).

3) Root khud leaf ho sakta hai (single node tree) - tab wo leaves wali
   recursion me dobara add ho jaata hai. head reference pass karke skip karo.

4) Right boundary reversed chahiye - LinkedList + addFirst se ek hi pass
   me ho jaata hai. Alag se reverse karne ki zaroorat nahi.

5) Merge me for-each use karo. LinkedList pe get(i) O(n) hai,
   indexed loop O(n^2) bana dega.

Complexity: Time O(n)  - leaves poora tree, boundaries O(h) each
            Space O(h) - recursion stack
*/
