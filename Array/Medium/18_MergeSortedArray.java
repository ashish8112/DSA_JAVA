import java.util.*;
class MergeSortedArray{
  public static void merge(int [] nums1,int [] nums2,int m,int n)
  {
    int i=m-1;
    int j=n-1;
    int k=m+n-1;
    while(j>=0)
      {
        if(i>=0&&nums1[i]>nums2[j])
        {
          nums1[k--]=nums1[i--];
        }
        else
        {
          nums1[k--]=nums2[j--];
        }
      }
  }
  public static void mergeAlternate1(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=nums1.length-1;
        while(j>=0&&i>=0)
        {
            if(nums1[i]>=nums2[j])
            {
                nums1[k--]=nums1[i--];
            }
            else{
                nums1[k--]=nums2[j--];
            }
        }
        while(j>=0)nums1[k--]=nums2[j--];//because I exhausted every element in I are added in nums1 because they are larger no need to check i>=0 and append
    }
  public static void mergeAtlernate2(int[] nums1, int m, int[] nums2, int n) {  
        int i=m-1;
        int j=n-1;
        int k=nums1.length-1;
        while(i>=0&&j>=0)
        {
            if(nums1[i]>=nums2[j])
            {
                nums1[k--]=nums1[i--];
            }
            else 
            {
                nums1[k--]=nums2[j--];
            }
        }
        while(i>=0)  //Thinking like merging two arrays in another array although it doesn't require reason  is written above 
        {
            nums1[k--]=nums1[i--];
        }
        while(j>=0)
        {
            nums1[k--]=nums2[j--];
        }
    }
  public static void main(String [] args)
  {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of nums1 (m): ");
        int m = sc.nextInt();
        System.out.print("Enter size of nums2 (n): ");
        int n = sc.nextInt();
        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];
        System.out.println("Enter "+m+" elements in array with sorted manner ");
        for(int i=0;i<m;i++)nums1[i]=sc.nextInt();
        System.out.println("Enter "+n+" elements in array with sorted manner ");
        for(int j=0;j<n;j++)nums2[j]=sc.nextInt();
        merge(nums1,nums2,m,n);
        System.out.println(Arrays.toString(nums1));
  }
}

/* Pattern -> Two Pointer (Starts from end)
  Trigger words -> MergeSorted Arrays without extra space , In place merge , sorted + extra space at the end 
  Insights 
  why start from end ??
  Because If we start from start it will overwrite the values 
  both array are already sorted and highest element of both array are at the end just to need to check highest among both.

  why(j>=0)
  because we have to merge second array in first if it is empty no need to check anything and while merging if second array got exhausted no need to check further

  why to check i>=0
  2 reasons : 1 -> If I smaller than 0 it means all element of array1 is merged in it's own array1 at the end and only array2 elements are remaining to merge
              2-> To avoid IndexOutofBound error , if i pointer is exhaust no need to check with second array , merge second array till (j>=0) .
  */
