//Question top k frequent element means number of k element who have most frequency for example [1 1 1 2 2 3] k =2 {1:3,2:2,3:1} top k is [1,2] becuase element 1 and 2 has toppest frequency than another ones 
class Solution { // Brute force 
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.putIfAbsent(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
        }
        int [] freq = new int[map.size()];
        int j=0;
        for (int i:map.keySet())
        {
            freq[j++]=map.get(i);
        }
        j=0;
        Arrays.sort(freq);
        int low =0;
        int high = freq.length-1;
        while(low<high) // to get highest frequency first and smallest last 
        {
            int temp = freq[low];
            freq[low++]=freq[high];
            freq[high--]=temp;
        }
        int [] ans = new int[k];
        for(int i:map.keySet())
        {
            if(map.get(i)>=freq[k-1]) // why freq[k-1] because that threshold k-1 top kth element in 0th index array now we have to find any element who have frequency more that value in our map
            ans[j++]=i;
        }
        return ans;
    }
}
//TIme complexity = o(nlogn)
//Space Complexity = o(n) 

class Solution { //Optimal Approach
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.putIfAbsent(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
        }
        List<Integer> [] frequencyArray = new ArrayList [nums.length+1]; // array of arrayList.
        for(int i=0;i<=nums.length;i++)
        {
            frequencyArray[i]= new ArrayList<>();
        }
        for(int i:map.keySet()){
            int freq = map.get(i);
            frequencyArray[freq].add(i); //because array index nums[i] but instead we do nums[i].add(x) becuase nums[i] become object name see in above loop
        }
        int [] ans = new int [k];
        int index =0;
        for(int i=nums.length;i>=0;i--)
        {
            for(int j =0;j<frequencyArray[i].size();j++) // or simpler for(int element : frequencyArray[i]);
            {
                ans[index++]=frequencyArray[i].get(j);
                if(index==k)
                return ans;
            }
        }
        return new int [] {-1,-1};
    }
}

// Question puchh raha hai  top k frequent elements return karo  matlab woh k elements jinki frequency sabse zyada hai just like I explained on top 

// Key Observation 1: Maximum Frequency of any element cannot be more than n which is length of array [1,1,1] frequency of 1 is 3
// Toh hum ek frequency array banayenge jismein index = frequency, value = element honga 

//Now question is that what should be size of frequency array  our mind may think size as much our original array is n but it is wrong why let's see below 
// remeber in frequency array index is frequency of element and value of frequency array is element of original array 
//Original Array = [1,1,1]
//   frequency(Index)   value(Element of Original Array)
//          0              0
 //         1              0
//          2              0
//          3              1  //but if size would be n we would not able to do this in that array becuase of out of index so we need size n+1

//Second Question why and what is this List<Integer> [] bucket = new ArrayList [n+1] 
//so answer is this an array nothing else but we have studied array is collection same data type so instead of int data type we use List so it array of list or array of arrayList
//            syntax of array ->  datatype [] name = new datatype [size] => List<Integer> [] bucket= new ArrayList [n+1] , as we know List is interface so we use ArrayList instead of List

// now why array of list why not array of int so answer is that multiple elements can have single frequency let's see with example 
//nums = [1, 1, 2, 2, 3]  -> map = {1:2, 2:2, 3:1}
// Agar int[] hota
// bucket[2] = 1? ya 2?  sirf ek store hoga ek pe ek overwrite hon jayega that why bucket[2] = list [] hona chahiye 
//so bucket [2] = [1,2] aise store kar sakein 


// Important: Abhi sab indices null hain frequency array ka becuase it is not initalized as it is not primitive datatype so before using we must have to initialize.oori hai:
// for(int i = 0; i <= n; i++) {
//     bucket[i] = new ArrayList<>();  // har index pe empty list banao
// }
//Bina initialize ke bucket[2].add(1) karenge toh NullPointerException aayega kyunki bucket[2] abhi null hai, koi list hai hi nahi wahan.


// Approach

// Step 1: HashMap se frequency count karo.
// nums = [1, 1, 2, 2, 3]
// map = {1:2, 2:2, 3:1}

// Step 2: Frequency array banao, initialize karo, HashMap se fill karo.
// for(int key : map.keySet()) {
//     int freq = map.get(key);    // O(1)
//     bucket[freq].add(key);      // O(1)  seedha index pe daalo
// }
// bucket[0] = []
// bucket[1] = [3]        3 ki frequency 1 hai
// bucket[2] = [1, 2]     1 aur 2 dono ki frequency 2 hai
// bucket[3] = []
// bucket[4] = []
// bucket[5] = []

// Step 3: Last index se traverse karo (highest to lowest frequency). Pehle k elements utha lo.

// k = 2
// -> bucket[5]=[], bucket[4]=[], ..., bucket[2]=[1,2]
// -> Pick 1, pick 2  k elements hongayein 
// -> ans = [1, 2]
  
// Time Complexity: O(n) — HashMap O(n) + frequency array fill O(n) + traverse O(n) = O(3n) = O(n)
// Space Complexity: O(n) — HashMap + bucket array
