/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution { //Brute force because of Space Complexity = o(n)
    public boolean hasCycle(ListNode head) {
        Set<ListNode>set = new HashSet<>();
        while(head!=null)
        {
            if(set.contains(head))
            return true;
            set.add(head);
            head=head.next;
        }
        return false;
    }
}
public class Solution { //Optimal Tortoise method
    public boolean hasCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while(fast!=null&&fast.next!=null)
      {
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast)
        return true;
      }
      return false;
    }
}
//Tortoise Method using two pointer 
//TIme complexity =o(n) becuase of if there is no cycle fast pointer will traverse entire linkedlist in n/2 but if there is cycle slow==fast in o(n) time means maximum 
//n time loop will execute and then we we will get our cycle

//Question : Is cycle exist to be noted cycle starting point is that from where again connection loop is start or where tail.next point, that is a starting point of cycle 
//In our approach fast and slow can be meet anywhere in nodes not at tail or starting point of cycle mandatory, it can be there but no fixed because cycle can be start from anywhere of nodes

