class Solution {
    public int findFloor(int[] arr, int x) {
        int index = -1;
        int low=0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]<=x)
            {
                index = mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return index;
    }
}
/*Floor in Sorted Array = Lower Bound ka mirror!
Lower Bound → arr[mid] >= target → save, go LEFT  (chhota index dhundo)
Floor       → arr[mid] <= x     → save, go RIGHT (bada index dhundo)
Default = -1 (agar koi element <= x nahi mila)
Complexity: Time O(log n), Space O(1)*/
