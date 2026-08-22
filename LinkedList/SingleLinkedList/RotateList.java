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
class Solution { //Brute force
    private void reverse(int low,int high,List<Integer>list)
    {
        while(low<high)
        {
           int temp = list.get(low);
           list.set(low,list.get(high));
           list.set(high,temp);
           low++;
           high--;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)
        return head;
        List<Integer>list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null)
        {
            list.add(temp.val);
            temp=temp.next;
        }
        k=k%list.size();
        reverse(list.size()-k,list.size()-1,list);
        reverse(0,list.size()-k-1,list);
        reverse(0,list.size()-1,list);
        temp=head;
        int i=0;
        while(temp!=null)
        {
            temp.val=list.get(i++);
            temp=temp.next;
        }
        return head;
    }
}
