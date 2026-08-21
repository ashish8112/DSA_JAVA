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
class Solution { //Using MegeSort
    public static ListNode mergeSort(ListNode head)
    {
        if(head==null||head.next==null)
        return head;
        ListNode slow = head;
        ListNode prev = slow;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode firstHalf = mergeSort(head);
        ListNode secondHalf = mergeSort(slow);
        return merge(firstHalf,secondHalf);
    }
    public static ListNode merge(ListNode left,ListNode right)
    {
        ListNode prev = new ListNode();
        ListNode sorted = prev;
        while(left!=null&&right!=null)
        {
            if(left.val<=right.val)
            {
                sorted.next = left;
                left=left.next;
                sorted=sorted.next;
            }
            else{
                sorted.next=right;
                right=right.next;
                sorted=sorted.next;
            }
        }
        while(left!=null)
        {
            sorted.next=left;
            left=left.next;
            sorted=sorted.next;
        }
        while(right!=null)
        {
            sorted.next = right;
            right = right.next;
            sorted=sorted.next;
        }
        return prev.next;
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}

//Time complexity =  at each recursion level, finding the middle + merging cose o(n) total because o(n) + o(n/2) 
//O(logn) for recursion * o(n) for merging + o(n/2) for finding middle because merging and finding middle is done enitrely n time for each recursion list = o(logn(n+n/2)) = o(nlogn)
//space complexity = O(1)

//Idea is simple find middle of linked list which makes two list left list and right list make sure after finding middle make sure left linked list is pointing to null at the end 
// perform breaking till left or right become single node linked list and then perform merging by taking one dummy linked list and connect the left and right list with dummy 
//in sorting order 

