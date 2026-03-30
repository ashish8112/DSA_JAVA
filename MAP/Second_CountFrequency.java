import java.util.*;
class Second_CountFrequency{
  public static void main(String [] args)
  {
    String s= "racecar";
    HashMap<Character,Integer>map = new HashMap<>();
    for(char c: s.toCharArray())
      {
        map.put(c,map.getOrDefault(c,0)+1);  //map.getOrDefault return the value of key if key doesn't exits return default value of argument like 0 here
      }                                      //so suppose a:1 so map.getOrDefault(a,0) -> it returns 1 so 1+1 becuase ,map.getOrDefault(a,0)+1

    // for(int i=0;i<s.length();i++)    //Use this or above
    // {
    //     char ch = s.charAt(i);
    //     map.put(ch,map.getOrDefault(ch,0)+1);
    // }
    
    for(Map.Entry<Character,Integer>entry : map.entrySet())  //**`Map.Entry` = ek row ka blueprint — key aur value dono saath!**
      System.out.println(entry.getKey()+" : "+entry.getValue());

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
