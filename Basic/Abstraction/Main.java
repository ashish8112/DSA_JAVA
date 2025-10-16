package DSA.Basic.Abstraction;

abstract class Animal{
    public abstract void eat();// Abstract Method
    public abstract void walk();
    public void sleep()//Concrete Method
    {
        System.out.print("Zzzzz");
    }
}
class Dog extends Animal{
  @Override
    public void eat()
    {
        System.out.println("Dog eats ");
    }
    public void walk()
    {
        System.out.println("Dog Walk ");
    }
}
 public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
        dog.walk();
        System.out.print("Dog Sleep ");dog.sleep();
    }
}