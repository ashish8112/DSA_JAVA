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
class Solution { // Brute Approach
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer>list = new ArrayList<>();
        for(int i=0;i<lists.length;i++)
        {
            ListNode temp = lists[i];
            while(temp!=null)
            {
                list.add(temp.val);
                temp=temp.next;
            }
        }
        Collections.sort(list);
        ListNode head = new ListNode();
        ListNode temp = head;
        for(int i=0;i<list.size();i++)
        {
            temp.next=new ListNode(list.get(i));
            temp=temp.next;
        }
        return head.next;
    }
}

//Time complexity = o(n) + o(nlogn) + o(n) = o(nlogn) 
//Space compelxity = o(n) + o(n) = o(n) 
