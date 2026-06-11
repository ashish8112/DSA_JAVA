class Solution { //Optimal Approach 
    public int kthElement(int nums1[], int nums2[], int k) {
      if(nums1.length>nums2.length) //instead of creating a new function I called the same function with smaller array.
      return kthElement(nums2,nums1,k); 
      int low = Math.max(0,k-nums2.length);
      int high = Math.min(k,nums1.length);
      while(low<=high)
      {
          int cut1 = low+(high-low)/2;
          int cut2=k-cut1;
          int left1=(cut1<=0)?Integer.MIN_VALUE:nums1[cut1-1];
          int left2=(cut2<=0)?Integer.MIN_VALUE:nums2[cut2-1];
          int right1=(cut1>=nums1.length)?Integer.MAX_VALUE:nums1[cut1];
          int right2=(cut2>=nums2.length)?Integer.MAX_VALUE:nums2[cut2];
          if(Math.max(left1,left2)<=Math.min(right1,right2))
          {
              return Math.max(left1,left2);
          }
          else if(left1>left2)
          high=cut1-1;
          else
          low=cut1+1;
      }
      return -1;
    }
}
//Pattern: Binary Search on Partition - Kth Element of 2 sorted Arrays
//Approach : Creating the parition in both array such like k elements are in left and remaining elements are right 
//Used same logic of median of two sorted array where half element are in left and another half element are in right 
// there we would find cut1 = x and cut2 = (arr1+arr2)/2 - cut1 why because we wanted half in left side total/2 is half and if x is from first array then half-x in second array for left 
//Here same cut1 = X , cut2= k-cut1, in median k was always half so there was (arr1+arr2)/2
//why k element in left ? because the boundary k element in left side which is a max(left1,left2) is our kth element 

// why low = Math.max(0,k-nums2.length); because suppose we have arr1 = 4 element and arr2 = 5 element and we want k = 7 
// if low is 0 means at any point mid can be 0 means cut1 =0 so cut2 = 7-0 = 7 means cut2 seven . left2 will be array index out of bound arr2[cut2-1] and
// another it is not our valid parition so we need to take low as max(0,k-nums2.length) so cut1 will have atleast that number of element which will help to maintain 
// k number of element in left side using arr1 and arr2 and if k is smaller than arr2.length out low will 0 because max(0,negative) 

//why high = math.min(k,nums1.length) we want search space till k because our maximum search space must be k only like arr1 have 5 element and our k is 2 so cut1 will be sometime 3,4and 5 so which is not valid parition 
// because there would be more than k element in left side , we want only k element example in median question half can be entire nums1 element or length of nums1array is smaller than half of total there is correct to 
// take high as nums1.length as already that Math.max(half,nums1.length) because nums1 is smallest array but here k can be greater than arr1 length and and can be smaller than nums 1 length so 
// we have to choose only min (k,nums1.length) and it helps to avoid array index of bound also suppose k = 5 and nums1 length is 3 so and we are high as k =5 and we have only 3 element so Math.min helps in both condition 
