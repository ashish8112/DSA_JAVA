class Solution {
    public int findCeil(int[] arr, int x) {
        int index =-1;
        int low =0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            if(arr[mid]>=x)
            {
                index=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return index;
    }
}
/*Ceil in Sorted Array = Lower Bound almost exact!
Lower Bound → default arr.length (insert position)
Ceil        → default -1 (element exist nahi karta)
Baaki sab same — arr[mid] >= x → save, go LEFT
Complexity: Time O(log n), Space O(1)*/

// Floor  → arr[mid] <= x  → save, go RIGHT → default -1
// Ceil   → arr[mid] >= x  → save, go LEFT  → default -1
// Lower  → arr[mid] >= x  → save, go LEFT  → default arr.length
// Upper  → arr[mid] >  x  → save, go LEFT  → default arr.length
