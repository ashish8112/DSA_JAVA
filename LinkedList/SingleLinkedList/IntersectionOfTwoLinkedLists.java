/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution { //Brtue force because of space complexity o(n+m)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode>set = new HashSet<>();
        while(headA!=null&&headB!=null)
        {
            if(!set.contains(headA))
            set.add(headA);
            else
            return headA;
            if(!set.contains(headB))
            set.add(headB);
            else
            return headB;
            headA=headA.next;
            headB=headB.next;
        }
        while(headA!=null)
        {
            if(!set.contains(headA))
            {
                set.add(headA);
                headA=headA.next;
            }
            else{
                return headA;
            }
        }
        while(headB!=null)
        {
            if(!set.contains(headB))
            {
                set.add(headB);
                headB=headB.next;
            }
            else
            return headB;
        }
        return null;
    }
}

public class Solution { // Better 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1=0,count2=0;
        ListNode t1=headA;
        ListNode t2 = headB;
        while(t1!=null){
            count1++;
            t1=t1.next;
        }
        while(t2!=null){
            count2++;
            t2=t2.next;
        }
        ListNode slow = headA;
        ListNode fast = headB;
        if(count1<count2)
        {   
            for(int i=0;i<count2-count1;i++)
            fast=fast.next;
        }
        else{
            for(int i=0;i<count1-count2;i++)
            slow=slow.next;
        }
        
        while(slow!=fast)
        {
            if(slow==fast)
            return slow;
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
