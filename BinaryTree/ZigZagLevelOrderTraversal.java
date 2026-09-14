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
            List<Integer>inList = new LinkedList<>();
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
