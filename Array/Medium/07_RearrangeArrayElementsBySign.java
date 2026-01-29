import java.util.*;
class RearrangeArrayElementsBySign{
   public static int[] rearrangeArray(int[] nums) { // Brute Force Approach
        int [] negative = new int [nums.length/2];
        int [] positive = new int [nums.length/2];
        int k=0,j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                negative[k++]=nums[i];
            }
            else if(nums[i]>-1)
            positive[j++]=nums[i];
        }
        for(int i=0;i<nums.length/2;i++)
        {
            nums[i*2]=positive[i]; //i => i+=2
            nums[i*2+1]=negative[i];//start j with 1 and j=> j+=2
        }
        return nums;
    }
   public int[] rearrangeArrayOpt(int[] nums) {
       int [] arr = new int [nums.length];
       int j=0,k=0;
       for(int i=0;i<nums.length;i++)
       {
        if(nums[i]<0)
        {
            arr[j*2+1]=nums[i];
            j++;
        }
        else if(nums[i]>-1)
        {
            arr[k*2]=nums[i];
            k++;
        }
       }
        return arr;
    }
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of Array ");
    int size = sc.nextInt();
    System.out.println("Enter the values in the array");
    int [] arr = new int [size];
    for(int i=0;i<arr.length;i++)
      arr[i]=sc.nextInt();
    arr=rearrangeArrayOpt(arr);
    for(int i=0;i<arr.length;i++)
      System.out.println(arr[i]+" ");
  }
}
//Pattern : Index Placement
//Rule/Strategy : Positive value in Even Value , Negative value in Odd Value.
//Code : Above
//Mistake : Tried Value based Swapping,Used flags for changing the order of signs , 
//          multiple if-else (Overcompliated logic)
//Avoid : Don't just to swapping,Decide position rule first.
