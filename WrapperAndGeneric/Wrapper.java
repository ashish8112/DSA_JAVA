//Class whose Object wraps or contains primitive data type  
//conversion of Primitive data type to Object Data type
//int to Integer , boolean to Boolean , long to Long , dobule to Double etc

class Main {
    public static void main(String[] args) {
        Integer obj = new Integer(12); // Deprecated , will be removed in future reason below notes
        Integer a = 12;//Autoboxing , Most efficient and clean because internally It calls .valueOf
        int b = a;//Unboxing 
        Integer obj2 = Integer.valueOf(12);  //Best Practice 
        Integer c = Integer.valueOf("12");//It also converts another data type of Integer beucase it return new Integer;
        
        
        //valueOf method return new Datatype 
        //ex for string new String and for bool new Boolean
        Boolean check = Boolean.valueOf(true);
        Boolean bobj = Boolean.valueOf("false");//it can covnert any data type of Boolean
        Boolean bobj2 = true;
        
        System.out.println("obj = "+obj+" a = "+a+" b = "+b+" obj2 = "+obj2+" c = "+c);
        System.out.println("check = "+check+" bobj = "+bobj+" bobj2 = "+bobj2);
        }
}  

//Note :
Integer obj = new Integer(12);  //  DEPRECATED -> It works but will be removed in future
//because new Integer create new object everytime which cause mermory wastage 
//so use Integer a = Integer.valueOf(12)
  //     Integer b = Integer.valueOf(12)
//although inside java valueOf create new object but here they both will use same object because 
//Integer.value() maintains cache from -128 to 127 
//
