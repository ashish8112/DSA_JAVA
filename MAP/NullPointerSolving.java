import java.util.*;
class NullPointer{
  public static void main(String [] args)
  {
    Map<String, Integer> map = new HashMap<>();
    map.put("a", 5);

    //Problem 1 -> int val = map.get("b");  //  Null Pointer Exception
    // "b" exist hi nahi — get() returns NULL
    // null ko int mein unbox karna — Error

    // Option 1 — getOrDefault
    int val = map.getOrDefault("b", 0);  //  "b" nahi mila toh 0 return 

    // Option 2 — containsKey check
    if (map.containsKey("b")) {  //O(n) Time Complexity
    int val2 = map.get("b");
    }
    
    // Problem 2 Classic frequency problem
    Map<Character,Integer>map2=new HashMap<>();
    String s= "Ashish";
    for (char c : s.toCharArray()) {
   // map2.put(c, map2.get(c) + 1);  //  NPE — pehli baar c nahi hai map mein , map.get(c) = null — null + 1 = BOOM
      // getOrDefault se
    map2.put(c, map2.getOrDefault(c, 0) + 1);  //  pehli baar 0+1 = 1
      }

    //Problem 3 
    Map<Integer, Integer> map3 = new HashMap<>();
    map3.put(1,10);
    //int val = map3.get(key);           //  NPE if key missing — null → int unbox
    Integer val3 = map.get(2);       //  null store ho jaayega — NPE nahi
  }
}
