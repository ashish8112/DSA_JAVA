package DSA.Basic.ExceptionHandling;

public class first {
    public static void main(String [] args)
    {
        int [] arr=new int[5];
        try{
            arr[6]=3;
            int result=5/0;
        }

        // We can use multiple exception in program . Exception is class and e is its object which have various methods.
        // like e.getMessagae() // It shows which kind of exception it is .
        catch(ArithmeticException e) //This exception will not execute because whenver you are getting exception in first line our compiler break from try.
                // Prints that exception becuase first exception is array index of bound as we are assigning on 7th position[6] in [5] .
        {
            System.out.println("You can't access it  because of exception ");
    }
        catch(Exception e) // we must give generic or exact exception name to execute catch and Exception is parent of every exception it can handle any
                            // any exception .
                            // Exception handles all type of Exception .
        {
            System.out.println(e.getMessage()); // it will show exception
            System.out.println(e); // whenever we print the object it print it's toString() method which returns a string
            System.out.println(e.toString()); // this same as object printing
        }
        System.out.println("hello");
    }
}
