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

class Solution { //Brute Force 
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
        return head;
        ListNode odd = new ListNode (head.val);
        ListNode ogOdd = odd;
        int count =1;
        ListNode traverse = head;
        while(traverse!=null)
        {
            count++;
            traverse=traverse.next;
            if(count%2!=0&&traverse!=null)
            {
                odd.next = new ListNode(traverse.val);
                odd=odd.next;
            }
        }
        count =1;
        traverse=head;
        while(traverse!=null)
        {
            count++;
            traverse=traverse.next;
            if(count%2==0&&traverse!=null)
            {
                odd.next=new ListNode(traverse.val);
                odd=odd.next;
            }
           
        }
        return ogOdd;
    }
}

//TIme complexity = o(2n) => o(n) 
// Space Complexity = o(n) 

class Solution { // Optimal Approach
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode odd= head;
        ListNode originalEven = head.next;
        ListNode even = head.next;
        while((odd.next!=null&&odd!=null)&&(even.next!=null&&even!=null))
        {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=originalEven;
        return head;
    }
}

//Time complexity = o(n)
//Space complexity = o(1)
