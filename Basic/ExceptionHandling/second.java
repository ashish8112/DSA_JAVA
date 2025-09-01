package DSA.Basic.ExceptionHandling;

public class second {
    public static void main(String [] args)
    {
        try {
            int result=5/0;
            int arr[]=new int[5];
        }
//        catch (Exception e) // you cannot create two exception with same genric name and if you want you can do with different exception name or subclass
//                              of exception class .
//        {
//            System.out.println(e.getMessage()); // it will show problem
//            System.out.println(e.getCause());
//            System.out.println(e); // This will show type of exception
//        }
//        catch(Exception | ArithmeticException e) // Insted of writing two catch block we can use pipe and we can use class and sublcass in same catch block
                                                // becuase every exception is sub class of Exception Class.
        catch(ArrayIndexOutOfBoundsException | ArithmeticException e) // Use pipe for multiple exception
//                NullPointerException , RuntimeException
        {
            System.out.println(e);
        }
    }
}
