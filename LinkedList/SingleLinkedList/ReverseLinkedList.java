/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution { //Optimal
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode curr  = head;
        ListNode prev = null;
        head=head.next;
        while(head!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=head;
            head=head.next;
        }
        curr.next=prev;
        return curr;
    }
}


class Solution { //Recursive method
    static ListNode reverse(ListNode prev,ListNode curr)
    {
        if(curr.next==null)
        {
            curr.next=prev;
            return curr;
        }
        ListNode head = reverse(curr,curr.next); // send my current value and next vale and connect with previous value in next line 
        curr.next=prev; // because of above line every next element will be connected in reverse so I not need to worry to lose connection just connect my next to prev.
        return head;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)
        return head;
        return reverse(null,head);

    }
}
