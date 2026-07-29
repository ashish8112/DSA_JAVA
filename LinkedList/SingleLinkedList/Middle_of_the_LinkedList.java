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
    public ListNode middleNode(ListNode head) {
        int count =0;
        ListNode traverse = head;
        while(traverse!=null)
        {
            count++;
            traverse=traverse.next;
        }
        count/=2; // why not +1 because our head is at first location always we need only half of number of it is odd because of int we get min value and if it is even there are two middle and question wants from second so it also perfect there.
        traverse=head;
        int check =1; 
        while(check<=count)
        {
            traverse=traverse.next;
            check++;
        }
        return traverse;
    }
}

class Solution { //Optimal 
    public ListNode middleNode(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       while(fast!=null&&fast.next!=null)
       {
        slow=slow.next;
        fast=fast.next; // or instead of two line of fast we can do fast=fast.next.next;
        fast=fast.next;
       }
       return slow;
    }
}
