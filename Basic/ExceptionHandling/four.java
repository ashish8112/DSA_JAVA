package DSA.Basic.ExceptionHandling;
// The thorw keyword is used to explicitly throw a single exception
// In simple word I can create my own Exception in program
// TO use throw keyword either use try , catch or in function declaration declares throws exception

public class four {
    public static void main(String[] args) {
    int age=100;
//    try{
//        if(age>45)
//            throw new ArithmeticException("More than 45 is not allowed ");// I can use inbuilt Exception my own message
//    }
//    catch (Exception e)
//    {
//        System.out.println(e); // Output will java.lang.ArithmeticException: More than 45 is not allowed
//        System.out.println(e.getMessage()); // Output will More than 45 is not allowed
//    }
        // Or we can create own exception using class
        try {
            if (age > 45) {
                throw new MyException("Hello Exception") ;// To throw Own Exception I need to create object of my own exception class
            }
        }
            catch(Exception e) // Mine exception is stored in e object
            {
                System.out.println(e); // Output will be without message DSA.Basic.ExceptionHandling.MyException
                System.out.println(e.getMessage());
                System.out.println(e);// Now because of message it will show output : DSA.Basic.ExceptionHandling.MyException: Hello Exception
            }


       }
}
class MyException extends Exception{ // But i Need to inherit the parent class of all exception which is a Exception
    public MyException(String Message)
    {
        super(Message);// This message will pass to its parnet class Exception from there we can print exception
    }
}

