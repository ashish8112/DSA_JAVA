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
