/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution { //Brtue force because of space complexity o(n+m)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode>set = new HashSet<>();
        while(headA!=null&&headB!=null)
        {
            if(!set.contains(headA))
            set.add(headA);
            else
            return headA;
            if(!set.contains(headB))
            set.add(headB);
            else
            return headB;
            headA=headA.next;
            headB=headB.next;
        }
        while(headA!=null)
        {
            if(!set.contains(headA))
            {
                set.add(headA);
                headA=headA.next;
            }
            else{
                return headA;
            }
        }
        while(headB!=null)
        {
            if(!set.contains(headB))
            {
                set.add(headB);
                headB=headB.next;
            }
            else
            return headB;
        }
        return null;
    }
}

public class Solution { // Better 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1=0,count2=0;
        ListNode t1=headA;
        ListNode t2 = headB;
        while(t1!=null){
            count1++;
            t1=t1.next;
        }
        while(t2!=null){
            count2++;
            t2=t2.next;
        }
        ListNode slow = headA;
        ListNode fast = headB;
        if(count1<count2)
        {   
            for(int i=0;i<count2-count1;i++)
            fast=fast.next;
        }
        else{
            for(int i=0;i<count1-count2;i++)
            slow=slow.next;
        }
        
        while(slow!=fast)
        {
            if(slow==fast)
            return slow;
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
//Time complexity = o(n) + o(m) + o(maxlength-minlength) + o(length of smallest) = o(n+m+(m-n) + o(n) ) = > o(n+2m) = o(n+m) 
//space complexity = o(1)

public class Solution { //Optimal
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1= headA;
        ListNode t2=headB;
        while(t1!=t2)
        {
            t1=t1.next;
            t2=t2.next;
            if(t1==t2)
            return t1;
            if(t1==null)t1=headB;
            if(t2==null)t2=headA;
        }
        return t1;
    }
}

//Suppose I am A and my friend is B we have to climb stairs, but A has 5 stairs to climb and B has 7 stairs to climb 
//Imaginde top of both staris are same but bottom both stairs are according to length of each startis 
        A        B
        A        B
        A        B
        A        B
        A        B
                 B
                 B

// we both friend starts climbing from botthom but both will start from there own stairs rule is that if you reach at top of your stairs you need to jump to ground and start 
//climping from botthom of another friend 
//so A climbed it's all stairs 5  and B is at is on 5th staris now A will jumb and start climbing from B stairs and B will continue it's own stairs 
//now A is at 1st stair of B and B is at it's own 6 th stair one step more A is  at 2nd stair of B and B is at 7stair of it's own now B completed it's stair now he will jump 
// to gorund and start climbing B staris now B is at 1st stair of A and A is 3rd stair of B means now they are parallel to each other 

                    A        B
                    A        B
                    A        B
                    A        B
  B is here ->      A        B <- A is here 
                             B
                             B

        that's what we need in linkedlist to make them traverse individual together if they have intersection they will meet at intersection after starting traversing 
        parallel

//Timme complexity = o(m+n) because we have to traverse both list if both have same length and don't intersect they are parallel automatic so will meet at null 
            // and if not same length and don't intesect also then they will be parallel after going to each other list and will automatic will meet at null
            // if intersection is there they meet so worst case will be o(length  of 1st list + length of 2nd list)
//space complexity = o(1)
