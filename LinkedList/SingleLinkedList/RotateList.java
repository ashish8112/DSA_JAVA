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
class SolutionBrute { //Brute force
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
class SolutionOptimal { // Optimal 
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)
        return head;
        ListNode tail = head;
        ListNode slow = head;
        ListNode fast = head;
        int count =1;
        while(tail.next!=null)
        {
            count++;
            tail=tail.next;
        }
        tail.next=head;
        k=k%count;
        for(int i=1;i<=k;i++)
        fast=fast.next;
        while(fast!=tail)
        {
            slow=slow.next;
            fast=fast.next;
        }
        head=slow.next;
        slow.next=null;
        return head;
    }
}
//TIme complexity = o(n) + o(k) + o(n-k) = o(2n) = o(n) 
//space complexity = o(1)

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
class SolutionOptimalV2 { //same as above optimal without fast pointer 
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)
        return head;
        ListNode tail = head;
        ListNode slow = head;
        int count =1;
        while(tail.next!=null)
        {
            count++;
            tail=tail.next;
        }
        tail.next=head;
        k=k%count;
        for(int i=1;i<count-k;i++)
        slow=slow.next;
        
        head=slow.next;
        slow.next=null;
        return head;
    }
}
//TIme complexity = same as above o(2n) because o(n) + o(n-k) = o(2n) approx = o(n) 
//Space complexity  = o(1)
