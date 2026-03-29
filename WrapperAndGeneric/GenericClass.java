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
      Student<String,Integer>student = new Student<>("Ashish",10);//we specify so java can catch compile time error .
      System.out.println("Name of Student = "+student.name+" and Roll no = "+student.id);
      Student<String,String>student2 = new Student<>("Rahul","11");//if I will pass integer as second parameter compilation error will occur because of safe check
      System.out.println("Name of Student = "+student2.name+" and Roll no = "+student2.id);
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

//Notes List is inteface which is generic 
// ArrayList internally Generic class hai!
/*
ArrayList<Integer> list = new ArrayList<>();
// Same jaisa tera Dog<String> obj = new Dog<>()!

HashMap<String, Integer> map = new HashMap<>();
// Same Student<String, Integer>!


## Quick Summary:
```
Raw Type     → Dog obj         warning, unsafe
Generic      → Dog<String>     type-safe, clean
Diamond <>   → new Dog<>()     right side repeat nahi
Multiple     → <N, R>          HashMap jaisa!
*/
