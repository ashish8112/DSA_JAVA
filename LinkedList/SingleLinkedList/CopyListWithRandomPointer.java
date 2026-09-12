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

class BruteSolution {
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


class BruteSolutionSameCodeButBetter {
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
            copy.random = map.get(temp.random); // if it doesn't exist it will return null which is we actually need here also so no problem. || map.get(null) ==> null
            temp=temp.next;
        }
        return map.get(head);
    }
}

//Time complexity = O(n)
//Space Complexity = O(n)


//Idea is to store copy node just next to original like -> A -> B -> C (original list) now -> A -> A' -> B -> B' -> C -> C' and then perform three operation on entire list 
//1.create a and connect copy node using next don't try to fix random becuase all nodes required for copylist may be not created untill end of list.
//2.store random pointer in copy node using original.random.next
//3.restore original list and disconnect from copy list and connect copy nodes to it's actual next pointer => copy.next = copy.next.next;

class OptimalSolutionWithoutHashMap { // Algorithm name -> Interleaving algorithm , interleave means to insert something between other things
    public Node copyRandomList(Node head) {
        if(head==null)
        return head;
        Node temp = head;
        while(temp!=null) //create copy nodes and put next to original only 
        {
            Node copy = new Node(temp.val);
            copy.next=temp.next;
            temp.next=copy;
            temp=copy.next;
        }
        temp = head;
        while(temp!=null) //connect random pointer of copy using original list => copy.random => original.random.next
        {
            Node copy = temp.next;
            if(temp.random!=null)
            copy.random = temp.random.next;
            temp = copy.next;
        }
        temp = head;
        Node copyHead = temp.next;
        while(temp!=null) // disconnect original and copy list and store actual node for copy list using copy.next = copy.next.next;
        {
            Node copy = temp.next;
            temp.next = copy.next;
            if(copy.next!=null)
            copy.next=copy.next.next;
            temp=temp.next;
        }
        return copyHead;
    }
}

//Time complexity = O(n + 2n + 2n ) = > O(n) 
//Space Complexity = O(1) because copy node is output node which is required so it is not considered as Auxiliary space
