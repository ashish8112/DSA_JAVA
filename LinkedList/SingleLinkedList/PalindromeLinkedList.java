class Solution { //Brute using Stack
    public boolean isPalindrome(ListNode head) {
        Stack<Integer>stack = new Stack<>();
        ListNode traverse = head;
        while(traverse!=null)
        {
            stack.push(traverse.val);
            traverse=traverse.next;
        }
        while(head!=null)
        {
            if(stack.pop()==head.val)
            head=head.next;
            else
            return false;
        }
        return true;
    }
}

class Solution { //Brute using List
    public boolean isPalindrome(ListNode head) {
        List<Integer>list = new ArrayList<>();
        while(head!=null)
        {
            list.add(head.val);
            head=head.next;
        }
        int low = 0;
        int high =list.size()-1;
        while(low<high)
        {
            if(list.get(low)==list.get(high))
            {
                low++;
                high--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

class Solution { //Optimal Approach but linkedlist is modified not same as actuall 
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev = slow;
        slow=slow.next;
        prev.next=null;
        ListNode curr = slow;
        while(slow!=null)
        {
            slow=slow.next;
            curr.next = prev;
            prev=curr;
            curr=slow;
        }
        curr=prev;
        slow=head;
        while(curr!=null)
        {
            if(slow.val==curr.val)
            {
                slow=slow.next;
                curr=curr.next;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
//Approach reverse the linked List from the middle means point middle to null and last element from point null to its previouus element 

class Solution { //Same as above but linkedlist remaine same as before after palindrome checks
    public static ListNode reverse(ListNode add)
    {
        ListNode prev = null;
        ListNode curr = add;
        while(add!=null)
        {
            add=add.next;
            curr.next=prev;
            prev=curr;
            curr=add;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode ogTail = reverse(slow);
        ListNode curr=ogTail;
        slow=head;
        while(curr!=null)
        {
            if(slow.val==curr.val)
            {
                slow=slow.next;
                curr=curr.next;
            }
            else{
                reverse(ogTail);
                return false;
            }
        }
        reverse(ogTail);
        return true;
    }
}
