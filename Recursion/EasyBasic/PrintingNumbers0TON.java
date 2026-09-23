package DSA.Recursion;

public class PrintingNumbers0TON {
    int count=0;
    void print(int n)
    {
        if(count==n)
            return;
        System.out.println(count);
        count++;
         print(n);
        System.out.println("Hello"); // after satisfying the base the condition this line will start executing till clearing
        //stack recursion  and after this line .
        // it will again come to above line because previous print(5) had called this function . that will happen until clearing
        // the stack of calls and then it compiler will go where first function was called. 
    }

    public static void main(String[] args) {
        PrintingNumbers0TON obj= new PrintingNumbers0TON();
        obj.print(5);
    }
}
