class Main {
    public static <E> void printData(E data)
    {
        System.out.println(data);
    }
    public static <E extends Number> void printNumber(E data)//Bounded Generic Methods now It will only take int , long , double etc of numbers only 
    //if you try to send another datatype it will give compilation error 
    {
        System.out.println("Bounded Generic Method = "+data);
    }
    public static void main(String[] args) {
        printData("Ashish");
        printData(12);
        printData(false);
        Customclass obj = new Customclass();
        printData(obj);//if we tried to print object it prints 
        //classname@hashCode  (reference)  
        printNumber(12);
        printNumber(4.24);
        // printNumber(obj); It will display -> error: method printNumber in class Main cannot be applied to given types;
    }
}

class Customclass{
    
}

//To fix class name and hashcode we can override toString() method , it is not part of generic or wrapper 
//it is like prinitng class name by default or by user specified name 
// class Customclass {
//     @Override
//     public String toString() {
//         return "Main ka Custom Object!";
//     }
// }
// Ab printData(obj) → "Main ka Custom Object!" print karega


//Note in every object toString() method honta hain by default classname@hashcode return karta hain 
// so usko override karke ham apne according return kar saktey hain jo bhi chahe like above we do in comments 
