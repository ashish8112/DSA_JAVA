/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public int lengthOfLoop(Node head) {
        Node fast = head;
        Node slow = head;
        int count =0;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                Node test = head;
                while(test!=slow)
                {
                    slow=slow.next;
                    test=test.next;
                }
                while(slow.next!=test)
                {
                    count++;
                    slow=slow.next;
                }
                return count+1;
            }
        }
        return count;
    }
}

//In this approach in first phase we are finding cycle  which is o(n) in worst case where fast pointer moves n time till slow and fast meets and then 
//and in phase 2 we will find the starting point of cycle and after getting starting point of cycle start another pointer from there to traverse till again starting point with counter
//which is incrementing every time while traversing the node 
//TIme complexity = o(n) for getting cycle , o(L) for finding the starting point of cycle and o(k) where L & k <= n so => o(n) + o(L) + o(k) => o(3n) because L<=n && k<=n so o(3n) = o(n)
//space complexity = o(1)


class Solution { //Optimal 
    public int lengthOfLoop(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                int count=1;
                while(slow.next!=fast)
                {
                    count++;
                    slow=slow.next;
                }
                return count;
            }
        }
        return 0;
    }
}

//Time Complexity = o(n) => o(n) for finding cycle or not, o(k) k length of cycle = o(n) + o(k) where k<=n so o(n) + o(n) = o(n) 
//Space Complexity = o(1)
