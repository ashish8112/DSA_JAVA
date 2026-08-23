class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data==x)
            {
                if(temp.prev!=null)
                temp.prev.next=temp.next;
                else
                head=temp.next;
                if(temp.next!=null)
                temp.next.prev=temp.prev;
                
            }
            temp=temp.next;
        }
        return head;
    }
}

//Idea -> if previous is null move head one step next , if previous is not null add the address of current occurence node next's in previous node's next and then 
// if next is not of occurrence node add the previous address of next node of occurenece with occurence previous node .
