public class Solution { //Brute force
    public ListNode detectCycle(ListNode head) {
        Set<ListNode>set = new HashSet<>();
        while(head!=null)
        {
            if(set.contains(head))
            return head;
            set.add(head);
            head=head.next;
        }
        return null;
    }
}

public class Solution { //Optimal Approach 
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                ListNode test = head;
                while(test!=slow)
                {
                    slow=slow.next;
                    test=test.next;
                }
                return slow;
            }
        }
        return null;
    }
}
