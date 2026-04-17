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


//Optimal Approach
    //Intution
//    Consider the array [2, 3, 4, 7, 11]. In a perfect world with no missing numbers, every element should satisfy value = index + 1. (indexing start from 1)
//    The moment a value is larger than index + 1, it means some numbers were skipped. Take index 3, value 7. Since 7 is the 7th positive integer, 
//    exactly 6 numbers should appear before it. But index 3 means only 3 slots are filled before it (indices 0, 1, 2). So out of the 6 numbers 
//    that should exist before 7, only 3 are actually present — meaning 3 numbers are missing. This gives us the formula: missing = arr[mid] - (mid + 1)
// At each index:

// Index 0, value 2 → 2 - 1 = 1 missing
// Index 1, value 3 → 3 - 2 = 1 missing
// Index 2, value 4 → 4 - 3 = 1 missing
// Index 3, value 7 → 7 - 4 = 3 missing
// Index 4, value 11 → 11 - 5 = 6 missing


// Finding the Answer
// We want the 5th missing number (k = 5). Binary search finds the boundary where missing count crosses k:

// At index 3 → 3 missing (less than 5) ✓
// At index 4 → 6 missing (greater than 5) ✗

// So the answer lies just after index 3 (value 7). At this point, 3 numbers are already missing. We need 2 more (5 - 3 = 2). Starting from 7, 
// the next missing numbers are 8 (4th) and 9 (5th). Answer = 9.
// Algebraically: arr[high] + (k - missing_at_high) simplifies to high + k + 1 because arr[high] cancels out — and this formula even handles the edge case when high = -1.
