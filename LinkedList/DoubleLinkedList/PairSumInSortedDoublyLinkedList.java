/* Structure of Doubly Linked List Node
class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}; */

class Solution { 
    public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node low = head;
        Node high = head;
        while(high.next!=null)high=high.next;
        while(low!=high&&low.prev!=high)
        {
            int sum = low.data+high.data;
            if(sum==target)
            {
                ArrayList<Integer>pair = new ArrayList<>();
                pair.add(low.data);
                pair.add(high.data);
                list.add(pair);
                low=low.next;
                high=high.prev;
            }
            else if(sum<target)
            low=low.next;
            else
            high=high.prev;
        }
        return list;
    }
}
