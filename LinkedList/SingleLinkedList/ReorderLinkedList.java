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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
        return ;
        List<Integer>list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null)
        {
            list.add(temp.val);
            temp=temp.next;
        }
        List<Integer>backup = new ArrayList<>();
        int low =0;
        int high = list.size()-1;
        for(int i=0;i<list.size();i++)
        {
            if(i%2==0)
            {
                backup.add(list.get(low));
                low++;
            }
            else{
                backup.add(list.get(high));
                high--;
            }
        }
        temp = head;
        low=0;
        while(temp!=null)
        {
            temp.val=backup.get(low++);
            temp=temp.next;
        }
    }
}
