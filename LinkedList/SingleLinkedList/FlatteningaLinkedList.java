/* Structure of Linked List Node
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}*/

class BruteSolution {
    public Node flatten(Node head) {
        Node temp = head;
        while(temp!=null)
        {
            Node bottom = temp ;
            while(bottom.bottom!=null)
            bottom=bottom.bottom;
            bottom.bottom=temp.next;
            temp=temp.next;
        }
        temp=head;
        List<Integer>list = new ArrayList<>();
        while(temp!=null)
        {
            list.add(temp.data);
            temp=temp.bottom;
        }
        Collections.sort(list);
        temp=head;
        int i=0;
        while(temp!=null)
        {
            temp.data=list.get(i++);
            temp=temp.bottom;
        }
        return head;
    }
}
//k=horizontal nodes and m is vertical nodes in each k 
//Time Complexity = O(k*m + k*m * k*m log(k*m) + k*m) = O(k*m(3+log(k*m))) = O(k*m log(k*m)) 
//Space Complexity = O(k*m);

class SolutionMergeFold { //Note it is slow than brute also.
    public Node flat(Node head)
    {
        if(head==null||head.next==null)
        return head;
        Node head2 = flat(head.next);
        head = merge(head,head2);
        return head;
    }
    public  Node merge(Node head1,Node head2)
    {
        Node dummyHead = new Node(-1);
        Node sorted = dummyHead;
        head1.next=null;
        head2.next=null;
        while(head1!=null&&head2!=null)
        {
            if(head1.data<=head2.data)
            {
                sorted.bottom = head1;
                head1=head1.bottom;
                sorted=sorted.bottom;
            }
            else{
                sorted.bottom = head2;
                head2=head2.bottom;
                sorted=sorted.bottom;
            }
        }
        if(head1!=null)
        sorted.bottom=head1;
        else
        sorted.bottom=head2;
        return dummyHead.bottom;
    }
    public Node flatten(Node head) {
        return flat(head);
    }
}

//k=horizontal nodes and m is vertical nodes in each k 
//Time Complexity = k(Recursion) * merge() => k*(m+m) with accumlated always  
//Merge	Chhoti list	Accumulated list	Cost
Merge small_list accumlated_list cost
// 1	  m	            m	          2m
// 2	  m	            2m	        3m
// 3	  m	            3m	        4m
// ...			
// k−1	m	            (k−1)m	    k*m

// Total = m+ 2m + 3m + ... + km = m(k^2+k−2)/2 approx m*k^2/2

// N = k*m  
//Final Time Complexity = O(N × k)
//Space complexity = O(k) for recursion.

class SolutionMergeSort {
    public  Node merge(Node list1,Node list2)
    {
        Node dummyHead = new Node(-1);
        Node sorted = dummyHead;
        while(list1!=null && list2!=null)
        {
            if(list1.data<=list2.data)
            {
                sorted.bottom = list1;
                list1=list1.bottom;
                sorted=sorted.bottom;
            }
            else{
                sorted.bottom = list2;
                list2=list2.bottom;
                sorted=sorted.bottom;
            }
        }
        if(list1!=null)
        sorted.bottom=list1;
        else
        sorted.bottom=list2;
        return dummyHead.bottom;
    }
    public Node flatten(Node head) {
        if(head==null||head.next==null)
        return head;
        Node slow =head;
        Node fast = head;
        Node prev = slow;
        while(fast!=null&&fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        Node left = flatten(head);
        Node right = flatten(slow);
        return merge(left,right);
    }
}
//k = horizontal nodes , m is total number of nodes in k node vertically 
//Time Complexity = n = K*m at every level n nodes are getting merged and levels are logk => (n * log k)
//Space Complextiy = O(log k)

