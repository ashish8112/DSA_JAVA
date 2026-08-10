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
