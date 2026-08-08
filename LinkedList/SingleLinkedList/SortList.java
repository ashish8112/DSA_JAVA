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
class Solution { //Using MegeSort
    public static ListNode mergeSort(ListNode head)
    {
        if(head==null||head.next==null)
        return head;
        ListNode slow = head;
        ListNode prev = slow;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode firstHalf = mergeSort(head);
        ListNode secondHalf = mergeSort(slow);
        return merge(firstHalf,secondHalf);
    }
    public static ListNode merge(ListNode left,ListNode right)
    {
        ListNode prev = new ListNode();
        ListNode sorted = prev;
        while(left!=null&&right!=null)
        {
            if(left.val<=right.val)
            {
                sorted.next = left;
                left=left.next;
                sorted=sorted.next;
            }
            else{
                sorted.next=right;
                right=right.next;
                sorted=sorted.next;
            }
        }
        while(left!=null)
        {
            sorted.next=left;
            left=left.next;
            sorted=sorted.next;
        }
        while(right!=null)
        {
            sorted.next = right;
            right = right.next;
            sorted=sorted.next;
        }
        return prev.next;
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}
