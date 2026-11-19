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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode temp = head;
        ListNode prev = head;
        while(temp!=null)
        {
            ListNode curr = temp;
            temp=temp.next;
            if(temp==null)
            {
            prev.next=curr;
            break;
            }
            ListNode next = temp.next;
            temp.next= null;
            ListNode returned = reverse(curr);
            if(curr==head)
            head=returned;
            else
            prev.next=returned;
            prev=curr;
            temp=next;
        }
        return head;
    }
}
// Time complexity : O(n) 
// Space : o(1)
