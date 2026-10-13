class Solution {
    private static void reverse(Stack<Integer> st)
    {
        if(st.isEmpty())
        return;
        int top = st.pop();
        reverse(st);
        insert(st,top);
    }
    private static void insert(Stack<Integer>st,int value)
    {
        if(st.isEmpty())
        {
            st.push(value);
            return;
        }
        int top = st.pop();
        insert(st,value);
        st.push(top);
    }
    public static void reverseStack(Stack<Integer> st) {
       reverse(st);
       return;
    }
}

//Time complexity = O(n^2) 
//Space Complexity = O(n)

/*
Pattern: Recursion as Hidden Stack (Reverse Stack / Insert at Bottom)

Trigger: Stack ko bina extra data structure ke modify karna hai
         (reverse, sort, insert at bottom).

Template:
    reverse(st):
        if empty return
        top = pop
        reverse(st)                 
        insertAtBottom(st, top)

    insertAtBottom(st, x):
        if empty -> push x, return
        t = pop
        insertAtBottom(st, x)
        push t

Key Insights:
1) "No extra space" me call stack hi storage hai. Har frame ka local
   variable ek element pakad ke rakhta hai.
2) Popped element BOTTOM pe jaata hai, top pe nahi. Isliye ek doosri
   recursion chahiye: insertAtBottom.
3) Dono functions same shape: pop -> recurse -> kaam karo.
   Sort Stack bhi isi pe banta hai (insertAtBottom ki jagah insertSorted).

Complexity: Time O(n^2), Space O(n) recursion stack
*/
