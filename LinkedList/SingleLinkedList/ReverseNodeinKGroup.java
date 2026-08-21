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
    private ListNode reverse(ListNode prev, ListNode curr)
    {
        if(curr==null)
        return curr;
        if(curr.next==null)
        {
            curr.next=prev;
            return curr;
        }
        
        ListNode head = reverse(curr,curr.next);
        curr.next=prev;
        return head;
    }
    private ListNode findKth(ListNode node,int k)
    {
        for(int i=1;i<k;i++)
        {
            if(node!=null)
            node=node.next;
            else
            return null;
        }
        return node;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null)
        return head;
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = null;
        while(temp!=null)
        {
          ListNode kthNode = findKth(temp,k);
          if(kthNode!=null)
          {
            next = kthNode.next;
            kthNode.next=null;
          }
          else{
            prev.next=temp;
            break;
          }
          ListNode reversedListHead = reverse(null,temp);
          if(temp==head)
          head=reversedListHead;
          else{
            prev.next=reversedListHead;
          }
          prev=temp;
          temp=next;
        }
        return head;
    }
}
