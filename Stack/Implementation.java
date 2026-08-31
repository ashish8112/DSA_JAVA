class Stack{
    private int top = -1;
    private int [] stack;
    Stack(int size)
    {
        this.stack=new int [size];
    }
    void push(int x)
    {
        if(top>=stack.length-1)
        {
            System.out.println("Stack is overflow");
            return ;
        }
        stack[++top]=x;
        System.out.println("Pushed Element = "+stack[top]);
    }
    int pop(){
        if(top==-1)
        {
            System.out.println("Stack is underflow");
            throw new java.util.EmptyStackException();
        }
        System.out.println("Popped Element = "+stack[top]);
        return stack[top--];
    }
    int top(){
        if(top==-1)
        {
            System.out.println("Stack is empty");
            throw new java.util.EmptyStackException();
        }
        return stack[top];
    }
    boolean isEmpty(){
       return top==-1;
    }
}
class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(6);
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(10);
        stack.push(5);
        System.out.print(stack.top());
        System.out.println(stack.isEmpty());
    }
}
