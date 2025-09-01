package DSA.Basic.ExceptionHandling;
// Throws is keyword which used during declaration of function so another programmer can understand that this function will may throw Exception
// Using throw we declare type of exception

// It's Just a precautionary measure.
public class five {
    static int getNumberFromArray (int [] arr) throws ArrayIndexOutOfBoundsException
    {

            return arr[8];
    }
    public static void main (String [] args) {
        int[] arr = new int[5];
        try {
            getNumberFromArray(arr); // throws in Declaration can warn reader that this function can show  throw error so use it in try catch block.
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Error handled "+ e.getMessage());
        }
    }

}
