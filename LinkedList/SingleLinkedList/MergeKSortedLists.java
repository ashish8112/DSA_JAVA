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

class Solution { //Optimal Aprroach
    ListNode mergeSort(ListNode [] lists,int low , int high)
    {
        if(low>=high)
        return lists[low];
        int mid = low+(high-low)/2;
        ListNode left = mergeSort(lists,low,mid);
        ListNode right = mergeSort(lists,mid+1,high);
        return merge(left,right);
    }
    ListNode merge(ListNode left,ListNode right)
    {
        ListNode dummyHead = new ListNode();
        ListNode sorted = prev;
        while(left!=null&&right!=null)
        {
            if(left.val<=right.val)
            {
                sorted.next = left;
                sorted=sorted.next;
                left=left.next;
            }
            else{
                sorted.next = right;
                sorted = sorted.next;
                right =right.next;
            }
        }
        if(left!=null)
        sorted.next=left;
        else
        sorted.next=right;
        return dummyHead.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1)
        return null;
        return mergeSort(lists,0,lists.length-1);
    }
}

//Time Complexity = o(n log k) 
// Space Complexity = o(log k) because of recursion stack
