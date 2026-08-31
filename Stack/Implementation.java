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

        @Override 
    public String toString(){
        if(top==-1)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<=top;i++)
            {
                sb.append(stack[i]);
                if(i<top)
                    sb.append(", ");
            }
        sb.append("]");
        return sb.toString();
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

class Stack<T>{ // Using Generic Stack in java
    private int top = -1;
    private Object[] stack; //Every index in Object stores reference or address of data 
    Stack(int size)
    {
        this.stack=new Object[size];
    }
    void push(T x)
    {
        if(top>=stack.length-1)
        {
            System.out.println("Stack is overflow");
            return ;
        }
        stack[++top]=x;
        System.out.println("Pushed Element = "+stack[top]); // we are able to print value with reference because of object.toString() method which called by println under the hood
    }
    @SuppressWarnings("unchecked")
    T pop(){
        if(top==-1)
        {
            System.out.println("Stack is underflow");
            throw new java.util.EmptyStackException();
        }
        System.out.println("Popped Element = "+stack[top]); // we are able to print value with reference because of object.toString() method which called by println under the hood
        // return (T) stack[top--]; //Instead of this do below one because we are decreasing top and it is memory leak gc of java will not remove it 
        T element = (T) stack[top];
        stack[top--]=null;
        return element ;
    }
    @SuppressWarnings("unchecked")
    T top(){
        if(top==-1)
        {
            System.out.println("Stack is empty");
            throw new java.util.EmptyStackException();
        }
        System.out.println(stack[top]);
        return (T)stack[top];
    }
    boolean isEmpty(){
       return top==-1;
    }
}
class Main {
    public static void main(String[] args) {
        Stack <Integer> stack = new Stack<>(5);
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(10);
        stack.push(5);
        stack.top();
        System.out.println(stack.isEmpty());
    }
}

