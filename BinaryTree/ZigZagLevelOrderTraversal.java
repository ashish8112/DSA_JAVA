class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
        return new ArrayList<>();
        List<List<Integer>>list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false; // instead this we can directly use (list.size()%2!=0) for false 
        while(!q.isEmpty())
        {
            List<Integer>inList = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.poll();
                inList.add(temp.val);
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
            if(reverse)
            Collections.reverse(inList);
            list.add(inList);
            reverse = !reverse;
        }
        return list;
    }
}

//Time complexity = O(n) + O(w/2) for reverse = > O(w/2)  but for n = > O(n/2) => O(n)
//Space complexity = O(w) width of level 

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
        return new ArrayList<>();
        List<List<Integer>>list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false;
        while(!q.isEmpty())
        {
            List<Integer>inList = new LinkedList<>(); // addFirst on List needs Java 21+ 
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.poll();
                if(reverse)
                inList.addFirst(temp.val);
                else
                inList.addLast(temp.val);
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
            list.add(inList);
            reverse = !reverse;
        }
        return list;
    }
}

//Time complexity = O(n) , becuase addFirst and addLast is O(1) 
//Space Complexity = O(w) 

/*
Pattern: Level Order BFS + Alternating Direction (Zigzag)

Trigger: Level-wise output chahiye par direction har level pe badalni ho.

Template:
    Queue<TreeNode> q; q.offer(root);
    boolean reverse = false;
    while (!q.isEmpty()) {
        int size = q.size();                  // SNAPSHOT
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode t = q.poll();
            level.add(t.val);
            if (t.left  != null) q.offer(t.left);
            if (t.right != null) q.offer(t.right);
        }
        if (reverse) Collections.reverse(level);
        reverse = !reverse;
        result.add(level);
    }

Key Insights:
1) Traversal order NAHI badalta - hamesha left phir right push karo.
   Sirf OUTPUT list ka order badalta hai. Queue ko chhedne ki zaroorat nahi.
2) Flag ki jagah result.size() % 2 bhi chalta hai - list me jitne levels
   already hain, wahi current level ka index hai.
3) Reversal bachani ho to LinkedList + addFirst() use karo - O(1).
   ArrayList pe add(0, val) mat karna, wo O(n) hai -> level O(n^2).
4) size snapshot loop se PEHLE, warna level boundary toot jaayegi.

Complexity: Time O(n), Space O(w) - w = maximum width
*/
