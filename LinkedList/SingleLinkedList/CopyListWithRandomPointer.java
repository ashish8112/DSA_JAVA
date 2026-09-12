/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
        return head;
        Map<Node,Node> map = new HashMap<>();
        Node temp = head;
        Node dummyHead = new Node(-1);
        Node ans = dummyHead;
        while(temp!=null)
        {
            if(dummyHead==ans)
            {
                dummyHead.next = new Node(temp.val);
                dummyHead = dummyHead.next;
            }
            if(temp.next!=null)
            dummyHead.next = new Node(temp.next.val);
            map.put(temp,dummyHead);
            temp=temp.next;
            dummyHead=dummyHead.next;
        }
        dummyHead = ans.next;
        temp=head;
        while(temp!=null)
        {
            dummyHead.random= map.getOrDefault(temp.random,null); // there is no need because if temp.random is not there it will return null
            dummyHead=dummyHead.next;
            temp=temp.next;
        }
        return ans.next;
    }
}

//Time complexity = O(n)
//Space Complexity = O(n)

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class SolutionSameCodeButBetter {
    public Node copyRandomList(Node head) {
        Map<Node,Node>map = new HashMap<>();
        Node temp = head;
        while(temp!=null)
        {
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        temp=head;
        while(temp!=null)
        {
            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp=temp.next;
        }
        return map.get(head);
    }
}

//Everything is same as above just better way to write
