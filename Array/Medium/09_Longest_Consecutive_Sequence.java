
class LongestConsectuive{
    public int longestConsecutive(int[] arr) { // Brute Approach
        if(arr.length<1)
        return 0;
        Arrays.sort(arr);
        int count =1,max=0;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]+1==arr[i+1])
            count++;
            else if (arr[i]==arr[i+1])
            continue;
            else {
                max = Math.max(max,count);
                count=1;
            }
        }
        max=Math.max(max,count);
        return max;
    }
}

class Solution { //Optimal but we are not using value of hashmap so switch to hashmap so we can consider this as better
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
        return 0;
       Map<Integer,Integer>map = new HashMap<>(); // I don't some methods of hashset so I used hashmap
       for(int i=0;i<nums.length;i++)
       {
            if(!map.containsKey(nums[i]))
            map.put(nums[i],i);
       }
       int max =1;
       
        for(int i:map.keySet())
        {
            if(map.containsKey(i-1))
            continue;
            int count = 1;
            int value=i;
            while(map.containsKey(value+1))
            {
                count++;
                max=Math.max(count,max);
                value++;
            }
        }
        return max;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
        return 0;
       Set<Integer>set = new HashSet<>(); 
       for(int i=0;i<nums.length;i++)
            set.add(nums[i]);
       int max =1;
       
        for(int i:set)
        {
            if(set.contains(i-1))
            continue;
            int count = 1;
            int value=i;
            while(set.contains(value+1))
            {
                count++;
                max=Math.max(count,max);
                value++;
            }
        }
        return max;
    }
}

//Problem -> To find consecutive digits means continous digits counts even they are scattered in array and not placed in consecutive order 
//Brute force approach was to sort entire array so consective digits will be placed in consecutive places which makes easier to count the maximum consecutive ,
//Note: two eqaul digits will count only one suppose nums[i] == nums[i+1] so skip it don't increase count from 1 to 2 

// Optimal Approach -> used hashset so it removes the problem of duplicate or equal digits which need extra logic to check , 
//Main working is that suppose we got any element like 100 check before 100 ,99 exist nums[i]-1 exist in set if yes then skip that element because we will count from lowest to largest 
// now suppose if not exists take an another loop and check if nums[i]+1 exists in hashset if yes count should be incremented till each forward element we found and comapare with max
//for longest consecutive that's how it is working 

//Time Complexity and Space Complexity = o(n) 
//suppose array is already sorted and in hashset [1,2,3,4] 1-1 =0 exist in hashset no then procedd forward and check each upcoming consecutive element from 1 so it will stop at 4 after 
//couning which is o(n) but now again outer loop when we get 2 is 2-1 exist yes continue  is 3-1 exist yes continue is 4-1 exist yes continue that's how o(n) 
//so o(n) + o(n) = o(2n) = o(n)

