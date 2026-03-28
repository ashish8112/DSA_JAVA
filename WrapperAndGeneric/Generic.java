import java.util.*;

class Main {
    public static void main(String[] args) {
       Dog obj = new Dog("Ashish");//this is raw use of Paramaterized Class you should speicify , else it will give unchecked warning . 
       System.out.println(obj.id);
       Dog obj2= new Dog(1);
       System.out.println(obj2.id);
      Dog <String> obj4 = new Dog<>("Aman");
      //Previous syntax was Dog<Non-Primitve Dataype> object_name = new Dog <Same name as left > (value);
      //but java says if you are already specifiying in left side why again in right side 
      //Note only Non-primitve can Datatype can be used 
      Student<String,Integer>student = new Student<>("Ashish",10);
      System.out.println("Name of Student = "+student.name+" and Roll no = "+student.id);
    }
}

//we can give multiple parameter <E, F,P> 
class Dog<E>{  //E is paramter which is usually in Uppercase now you can send any type of datatype 
    public E id;
    public Dog(E id)
    {
        this.id=id;
    }
}
class Student<N,R>{// We can give multiple parameter
  public N name;
  public R id;
  public Student(N name, R id)
  {
    this.name = name;
    this.id= id;
  }
}
