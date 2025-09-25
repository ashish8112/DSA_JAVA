package DSA.Basic.ExceptionHandling;

//Use of finally keyword . it is used with try only or try and multiple or single catch
//finally block execute code whether there is exception or not .it will run anyhow.
//There will be only one finally block in one program.
//We use finally block to close operation for connection to file or closing a file. etc.
//There are some cases when a finally block does not execute .
        //Use of System.exit() method
        //An exception occurs in finally block
        //The death of thread.
public class Third {
    public static void main(String [] args) // showcase of finally Keyword.
    {
        int [] arr= new int[5];
//        try{
//            System.out.println(arr[8]);
//        }
//        catch(ArrayIndexOutOfBoundsException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        finally{
//            System.out.println("I will run any how ");
//        }
//        System.out.println("Hello ");

        try {
            System.out.println(arr[8]); // Now I will don't handle exception so it will give exception and run finally block only
        } finally { // Note we can use only one finally block.
            System.out.println("I will run any how ");
        }
        System.out.println("Hello");//Because of Unhandled exception this code block will not run but finally block will run

    }
}
