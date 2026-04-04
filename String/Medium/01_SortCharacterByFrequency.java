class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>>list =new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        StringBuilder res = new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            char ch = list.get(i).getKey();
            int n = list.get(i).getValue();
            for(int j=0;j<n;j++)
            res.append(ch);
        }
        return res.toString();
    }
}

/*Pattern: Frequency Sort — HashMap + Entry List Sort
Trigger: "sort by frequency", "decreasing frequency order",
         "most frequent first", "arrange by occurrence count"
Approach:
  Step 1: HashMap mein frequency count karo — O(n)
  Step 2: entrySet() → List mein daalo — O(k)
  Step 3: List ko frequency ke basis pe sort karo (decreasing) — O(k log k)
  Step 4: Har character uski frequency baar StringBuilder mein append karo — O(n)
Template:
  // Step 1
  map.put(ch, map.getOrDefault(ch, 0)+1);
  // Step 2 & 3
  List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
  list.sort((a,b) -> b.getValue()-a.getValue());
  // Step 4
  for(Map.Entry<Character,Integer> entry : list) {
      char ch = entry.getKey();
      int freq = entry.getValue();
      for(int j=0;j<freq;j++) res.append(ch);
  }
Key Insights:
  - HashMap sort nahi hoti → entrySet() List mein daalo, tab sort karo
  - Map.Entry = C ka struct — key aur value ek saath ek object mein
  - k = unique characters → max 128 (ASCII), n pe depend nahi → k log k = constant
  - Frequency (value) kitni bhi ho — sorting sirf k keys pe hoti hai
  - Bucket Sort se O(n) theoretically possible — bucket[freq] = characters
    but k=128 fixed hone ki wajah se practically dono same hain
Complexity:
  Time  → O(n + k log k) = O(n)  [k max 128, constant]
  Space → O(n + k) = O(n)        [result + hashmap]*/
