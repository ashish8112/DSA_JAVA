class Solution {  //Brute Force
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int final_array [] = new int [nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length&&j<nums2.length)
        {
            if(nums1[i]<=nums2[j])
            final_array[k++]=nums1[i++];
            else
            final_array[k++]=nums2[j++];
        }

        while(i<nums1.length)
        final_array[k++]=nums1[i++];
        while(j<nums2.length)
        final_array[k++]=nums2[j++];
        if(final_array.length%2!=0)
        return (double)final_array[final_array.length/2];
        return (double)((double)final_array[final_array.length/2]+final_array[final_array.length/2-1])/2;
    }
}

class Solution {  //Optimal Solution
    public static double median (int [] nums1,int [] nums2)
    {
        int low =0;
        int high = nums1.length;
        while(low<=high)
        {
            int mid = low+(high-low)/2; // mid
            int cut1=mid;
            int cut2=(nums1.length+nums2.length)/2-cut1;
            int left1=(cut1<=0)?Integer.MIN_VALUE : nums1[cut1-1];
            int right1=(cut1>=nums1.length)?Integer.MAX_VALUE : nums1[cut1];
            int left2=(cut2<=0)?Integer.MIN_VALUE : nums2[cut2-1];
            int right2=(cut2>=nums2.length)?Integer.MAX_VALUE : nums2[cut2];
            if(Math.max(left1,left2)<=Math.min(right1,right2))
            {
                if((nums1.length+nums2.length)%2==0)
                return (double)((double)Math.max(left1,left2)+Math.min(right1,right2))/2;
                else
                return (double)Math.min(right1,right2);
            }
            else{
                if(left1>right2)
                high=mid-1;
                else
                low=mid+1;
            }
        }
        return 0;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans;
        if(nums1.length<=nums2.length)
        ans=median(nums1,nums2);
        else
        ans=median(nums2,nums1);
        return ans;
    }
}

// Step 1: Take smaller array to determine search space → smallest array
// Step 2: Initialize low = 0, high = nums1.length (not -1)
// Take mid and perform.
// Initialize four variables:

// left1, right1 → from nums1 array
// left2, right2 → from nums2 array

// As we know both arrays are already sorted:

// left1 <= right1 (because of partition in same array)
// left2 <= right2 (same)

// Step 3: Perform cutting/partition on search space using Binary Search.
// if (cut2 <= 0) take left2 = Integer.MIN_VALUE
// cut1 = (low + high) / 2, else left1 = nums1[cut1 - 1]

// if (cut1 == nums1.length) take Right1 = Integer.MAX_VALUE
// else Right1 = nums1[cut1]
// cut2 = Total/2 - cut1
// Same logic:
// if (cut2 <= 0) take left2 = Integer.MIN_VALUE
// else left2 = nums2[cut2 - 1]
// if (cut2 == nums2.length) take Right2 = Integer.MAX_VALUE
// else Right2 = nums2[cut2]
// Step 5: if (left1 > right2)
// high = mid - 1
// (We need to send maximum values in right and minimum value in left. Because cut1 will be more less to all elements will be pushed in right and cut2 will be 
//larger so values be pushed left.)
// else
// low = mid + 1
// Step 4: until → max(left1, left2) <= min(right1, right2)
// then if the above condition is true:
// Checks condition if total of both is even if (nums1+nums2 % 2 == 0)
// return max(L1, L2) + min(R1, R2) / 2
// else return Right2 → min(Right1, Right2)
// because border or starting of right side is median.

// Why left1 > Right2 ? 
// Because we already know left side array including (both nums1 and nums2 left side with cut) is larger than right side array.
// We check one if left1 > right2 that means we need to shift our cut partition in left side and move and push larger values in right side. 
// If (left1 > right2) fails that means may be both left1 and left2 is equall(==)(left1==right2) or larger values is found in left2
//(that's why above condition check is fail so we check to move our cut or mid ),
//that's we need to move cut partition in right side so larger values of second array 
// which is left2 pushed to right side because we increase cut of 1st array right side more so cut2 becomes less and larger values of array 2 pushed to right side,
// because cut partition is inversely proportional if cut1 increase cut2 decrease and vice-versa.
