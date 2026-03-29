class first{
   public static void main(String[] args) {
    HashMap<Integer,String> map = new HashMap<>();
    map.put(5,"Ashish");
    map.put(2,"Rahul");
    map.put(3,"Shubham");
    map.put(3,"Simran");
    System.out.println(map.size());
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
