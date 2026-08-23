/* Structure of Doubly Linked List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        if(head==null||head.next==null)
        return head;
        Node temp = head;
        while(temp.next!=null)
        {
            Node nextNode = temp.next;
            temp.next=temp.prev;
            temp.prev=nextNode;
            temp=nextNode;
        }
        temp.next=temp.prev;
        temp.prev=null;
        head=temp;
        return head;
    }
}
