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
class Solution { //Brute
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null||head==null)
        return null;
        int count =0;
        ListNode traverse = head;
        while(traverse!=null)
        {
            count++;
            traverse=traverse.next;
        }
        ListNode prev = head;
        ListNode curr = head;
        for(int i=0;i<count-n;i++)
        {
            prev = curr;
            curr=curr.next;
        }
        if((count-n)==0)
        head=head.next;
        else if(curr!=null&&curr.next!=null)
        prev.next = curr.next;
        else{
            prev.next=null;
        }
        return head;
    }
}
