//package DSA.Basic.OOP;
class parent{
    parent()
    {
        System.out.println("Default Constructor");
    }
    parent(int a)
    {
        System.out.println("Parameterized Constructor "+a);
    }
}
class child extends parent{
    child(){
        super();
    }

}
class first {
    public static void main(String [] args)
    {
        // parent p = new parent(10);
        // parent p= new parent();
        child c = new child();
    }
}
