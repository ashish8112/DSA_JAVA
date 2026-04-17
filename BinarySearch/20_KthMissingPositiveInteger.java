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

/*
 * INTUITION:
 * If no array existed, kth missing number = k itself.
 * Example: k=5, no array → answer is simply 5.
 *
 * But every present number <= k "steals" a missing slot.
 * So we shift k forward by 1 for each present number found.
 *
 * Example: arr=[1], k=1
 * Without array → 1st missing = 1
 * But 1 is present → it stole the 1st missing slot → now find 2nd missing
 * k shifts to 2 → answer = 2 ✓
 *
 * HOW IT WORKS:
 * arr = [2, 3, 4, 7, 11], k = 5
 *
 * arr[0]=2, 2<=5 → k=6  (2 stole a slot, shift target)
 * arr[1]=3, 3<=6 → k=7  (3 stole a slot, shift target)
 * arr[2]=4, 4<=7 → k=8  (4 stole a slot, shift target)
 * arr[3]=7, 7<=8 → k=9  (7 stole a slot, shift target)
 * arr[4]=11, 11<=9? NO  → break
 *
 * 11 > 9 means seat 9 doesn't exist in array → 9 is missing!
 * return k = 9 ✓
 *
 * CORE INSIGHT:
 * When arr[i] > k → k itself became a missing number.
 * No present number can steal it anymore → return k.
 */

// time complexity= O(n)
// space complexity= O(1)


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
// Algebraically: arr[high] + (k - missing_at_high) simplifies to high + k + 1 because arr[high] cancels out — 
//    and this formula even handles the edge case when high = -1. -> at array index out of bound scenario like below code 

//     class Solution {    //This will cause index out of bound of some scenario
//     public int findKthPositive(int[] arr, int k) {
//         int low = 0;
//         int high = arr.length-1;
//         while(low<=high)
//         {
//             int mid = low+(high - low)/2;
//             int missing = arr[mid]-(mid+1);
//             if(missing<k)
//             low=mid+1;
//             else
//             high = mid-1;
//         }
//         //now check at index high how much element is missing 
//         int missing = arr[high]-(high+1);
//         //after finding missing we do know it is less than our k missing so we need to chech how much we
//         // need to jump from current value of high to get kth missing value so 
//         //so use (k missing ) - (missing at high)   
//         int remainingMissing = k-missing;
//         //now we get our missing kth missing by adding current value with remainingMissing 
//         return arr[high]+remainingMissing;
//     }
// }

//Optimal code 
    class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = low+(high - low)/2;
            int missing = arr[mid]-(mid+1);
            if(missing<k)
            low=mid+1;
            else
            high = mid-1;
        }
       return high+k+1;
    }
}

/*Pattern: Binary Search on Sorted Array (missing count property)
Trigger: kth missing positive in sorted array — missing count formula used
Template: missing = arr[mid]-(mid+1), find boundary where missing crosses k
Key Insights: arr[high] cancels algebraically → high+k+1 handles edge case high=-1
Complexity: Time O(log n), Space O(1)*/
