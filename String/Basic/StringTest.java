package DSA.String.Basic;

public class StringTest {
    public static void main(String[] args) {
        String name=new String ("Ashish");
        String sname=new String("Ashish");
        System.out.println(name==sname+" Because two different object");// we are checking reference not string
        String a="Ram";
        String b="Ram";
        System.out.print(a==b);// we are checking reference not string , true because of same reference
        System.out.println(" Because a and b is pointing to same literal Ram");
        String c="Ashish";
        System.out.println(c==name);
        System.out.println(name.equals(sname)+" ,To compare string use this ");// checking string
    }
}
 /*As we know variable of class is nothing just address or reference of object of that class
         Every object of class is stored in Heap Memory because reference/pointer variable/address are stored in
         heap memory
         String is class so the variable of string will be stored in heap memory
        but trick is that if we create variable using new keyword it will store in two different
        address although the same literal/value
         but Java give us functionality to create the variable of string without new keyword
         and that values will store in string pool and if 2 or more variable have same literal
         java will not create 2 or 3 address for them it will point to first address of variable
        */
/*
        +-------------------------------------------------+
        |               HEAP MEMORY                       |
        |  +-------------------------------------------+  |
        |  |             String Pool                   |  |
        |  |  (Stores interned String literals/objects)|  |
        |  |  e.g., "Hello", "Java", "World"           |  |
        |  +-------------------------------------------+  |
        |                                                 |
        |  (General Heap Area for other objects)          |
        |  e.g., new String("Hello"), new Object(), etc.  |
        |                                                 |
        +-------------------------------------------------+
 */