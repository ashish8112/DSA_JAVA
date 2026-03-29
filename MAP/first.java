import java.util.*;
class first{
   public static void main(String[] args) {
    HashMap<Integer,String> map = new HashMap<>();
    map.put(5,"Ashish");
    map.put(2,"Rahul");
    map.put(3,"Shubham");
    map.put(3,"Simran");//modify the value 
    map.put(1,"Amrita");
    map.put(10,"Cube");
    System.out.println(map.size());
      
    //map.containsKey(key) , map.containsValue(value);
    System.out.println(map.containsKey(2));   //always pass key datatype else it will show error
    System.out.println(map.containsValue("Ashish"));
   
    //map.remove(Object key) 
    System.out.println("Removed value = "+map.remove(3)); // it returns removed value or null if it is not exists
   // String value = map.remove(6);   //so key 6 doesn't exists it will return null which can cause null pointer Exception. 
    //to avoid this we use option1
    String value = map.getOrDefault(6,"Not Found"); //so it will return Not found because value of map should be string as map <Integer,String>
      // Option 2 — containsKey check
    if (map.containsKey(6)) {
    String val = map.remove(6);
      }

    //map.remove(Object Key and Object Value); it returns true or false
      System.out.println(map.remove(11,"Cube"));
      System.out.println(map.remove(10,"Cube"));


   //Travesal of Map 
      
    for(int i:map.keySet())  //keySet returns all keys 
    {
      System.out.println(map.get(i)+" : "+i);  
    }
    for(String val:map.values())  //return only values 
      {
        System.out.println(val);
      }
     for(Map.Entry<Integer,String>entry:map.entrySet())  //**`Map.Entry` = ek row ka blueprint — key aur value dono saath!**
       System.out.println(entry.getKey()+" "+entry.getValue());
      //Note:
    //Map is interface and Entry is nested Interface of Map 
    // interface Map {
    // // ...
    // interface Entry<K, V> {   // ← andar wala interface!
    //     K getKey();
    //     V getValue();
    // }
   //}
    }
}
