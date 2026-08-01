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
