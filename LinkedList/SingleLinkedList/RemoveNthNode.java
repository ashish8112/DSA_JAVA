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
class Solution { // Better 
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

//Time complexity = o(n) + o(n) because if n = 1 means last element so o(2n) => o(n) 
//Space Complexity = o(1)

class Solution { //Optimal
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }
        ListNode prev = slow;
        while(fast!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        
        if(slow==head)
        return head.next;
        prev.next = slow.next;
        return head;
    }
}
// Time Complexity = o(n) because n can be length and ans it that length doesn't matter because fast will move till end of list means size of list so o(n) 
//Space Complexity = o(1)

//Approach -> Bring slow pointer to node which we have to delete for that maintain distance between slow and fast pointer of n and when move fast till null from there subtract n will be
//node which we have delete and there will be slow pointer and one edge case of head is explained below 
//slow will be at node which needed to removed so if it is not head connect previous node with next element of slow as question given n >=1 and <=size means it will not crash for null 
// pointer exception now come to point what if slow is at head means we have to remove head so  simply shift head to next element if it null then also fine if element would be single 
//after removing head it will contain null only.
