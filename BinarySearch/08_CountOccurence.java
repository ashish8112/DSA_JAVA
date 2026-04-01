class Solution {
    public static  int lowerBound(int [] arr,int target)
    {
        int low =0;
        int high=arr.length-1;
        int index = arr.length;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]>=target)
            {
                index=mid;
                high=mid-1;
            }
            else low = mid+1;
        }
        return index;
    }
    public static int upperBound(int [] arr,int target)
    {
        int low =0;
        int high=arr.length-1;
        int index = arr.length;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]>target)
            {
                index = mid;
                high=mid-1;
            }
            else low = mid+1;
        }
        return index;
    }
    int countFreq(int[] arr, int target) {
        int start = lowerBound(arr,target);
        if(start==arr.length||arr[start]!=target)
        return 0;
        int end = upperBound(arr,target);
        return end-start;
    }
}
//same as 07 question only need to return occurrence
