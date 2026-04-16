//Brute
class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashMap<Integer,Integer>present = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            present.put(arr[i],i);
        }
        int j = 1;
        for(int i=1;i<=arr.length+k;i++)
        {
            if(!present.containsKey(i))
            {
                if(j==k)
                return i;
                j++;
            }
        }
        return 0;
    }
}

time complexity = O(n)+O(n+k) = O(n+k)
space complexity = O(n) 

//better Approach 
class Solution {
    public int findKthPositive(int[] arr, int k) {
        for (int i = 0;i<arr.length;i++)
        {
            if(arr[i]<=k)
            k++;
            else{
                break;
            }
        }
        return k;
    }
}

time complexity= O(n)
space complexity= O(1)
