interface Animal{
  void eat();
  void sound();
}

class Dog implements Animal{
  @Override//Safety net if I do typo like void sond() compiler will say error because it doesn't exits in Animal , and If I not use it will create new method with typo
  pubic void sound()
  {
    System.out.println("Dog: Bhow Bhow ");
  }
  @Override
  public void eat()
  {
    System.out.println("Dog: Eating Bone");
  }
    public void fetch() {  //Dog's Own Method
        System.out.println("Dog: Ball leke aaya!");
    }
}
class Cat implements Animal{
  @Override
    public void sound() {
        System.out.println("Cat: Meow Meow!");
    }
    
    @Override
    public void eat() {
        System.out.println("Cat: Eating Fish");
    }
  public void purr() {  //Cat's Own Method
        System.out.println("Cat: Purrrrr...");
    }
}

public class Main{
  //Best benefit 
  public static void makeSound (Animal a)
  {
    a.sound();
  }
  public static void main (String [] args)
  {
    Animal a1 = new Dog();  // Animal reference - Dog object 
    a1.sound(); // Bhow Bhow 
    a1.eat(); //Eating Bone 
    //a1.fetch()  // Error Animal doesn't know fetch method 

    Animal a2 = new Cat();  // Animal refernce - Cat object 
    a2.sound(); //Meow Meow!
    a2.eat();  //" Eating Fish

    //Need to swap 
    a1=new Cat();  // above is all correct doesn't break code 
    a1.sound(); // Meow Meow!

    makeSound(new Dog());//Bhow Bhow!
    makeSound(new Cat());//Meow Meow!
  }
}

//Why a1.fetch() gave error 
//Animal knows only eat and sound method only 
//during run time, object method is called only that's why specific class method is running but fetch method is not animal method it gives compile time error.
