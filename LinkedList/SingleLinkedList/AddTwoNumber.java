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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1= l1;
        ListNode t2=l2;
        ListNode add = new ListNode();
        ListNode t3 = add;
        int carry =0;
        while(l1!=null&&l2!=null)
        {
            int sum = carry+l1.val+l2.val;
            carry=sum/10;
            sum=sum%10;
            t3.next=new ListNode(sum);
            t3=t3.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null)
        {
            int sum = carry+l1.val;
            carry=sum/10;
            sum=sum%10;
            t3.next=new ListNode(sum);
            t3=t3.next;
            l1=l1.next;
        }
        while(l2!=null)
        {
            int sum = carry+l2.val;
            carry=sum/10;
            sum=sum%10;
            t3.next=new ListNode(sum);
            t3=t3.next;
            l2=l2.next;
        }
        if(carry!=0)
        t3.next=new ListNode(carry);
            return add.next;
    }
}
