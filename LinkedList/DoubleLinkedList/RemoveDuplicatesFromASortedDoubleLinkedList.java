/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // code here
        Node slow = head;
        Node fast = head.next;
        while(fast!=null)
        {
            if(slow.data==fast.data)
            fast=fast.next;
            else
            {
            slow.next=fast;
            fast.prev=slow;
            slow=slow.next;
            fast=fast.next;
            }
        }
        slow.next=null;
        return head;
    }
}
