class Solution {
    Node deleteK(Node head, int k) {
        if(k==1 || head==null)
        return null;
        Node temp = head;
        Node prev = head;
        while(temp!=null)
        {
           for(int i=1;i<k;i++)
           {
               prev=temp;
               temp=temp.next;
               if(temp==null)
               break;
           }
           if(temp==null)
           break;
           prev.next=temp.next;
           temp=temp.next;
        }
        return head;
    }
}
//Time  complexity = O(n)
//Space complexity = o(1)



/*
Pattern: Delete Every K-th Node (Counting with Lagging Pointer)

Trigger: List me har k-th element delete/mark karna hai, global count se
         (list restart nahi, poore list me continuous counting).

Template:
    Node temp = head, prev = head;
    while (temp != null) {
        for (int i = 1; i < k; i++) {
            prev = temp;
            temp = temp.next;
            if (temp == null) break;
        }
        if (temp == null) break;
        prev.next = temp.next;   // k-th node delete
        temp = temp.next;        // aage se naya count shuru
    }

Key Insights:
1) prev ek step PEHLE update hota hai temp se, taaki loop ke baad
   prev = (k-1)-th node aur temp = k-th node ho.
2) k=1 special case ZAROORI hai, sirf optimization nahi. k =1 mtlb saare nodes delete + Inner loop
   k=1 pe kabhi chalta hi nahi, isliye prev kabhi update nahi hota
   aur head khud kabhi delete nahi hota - general loop se galat answer.
3) Do-level null check (inner break + outer break) zaroori hai jab
   list ki length k ka multiple na ho.
*/
