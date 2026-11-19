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
class Solution {
    public ListNode reverse(ListNode head)
    {
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null)
        {
            ListNode next = temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        ListNode prev = null;
        int count =0;
        while(temp!=null)
        {
            count++;
            if(count==left)
            {
                ListNode curr = temp;
                while(count!=right)
                {
                count++;
                temp=temp.next;
                }
                ListNode next = temp.next;
                temp.next=null;
                if(prev==null)
                head=reverse(curr);
                else{
                prev.next=reverse(curr);
                }
                curr.next=next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
}
// Time complexity : O(N)
// Space complexity : O(1)
