import java.util.*;
class MaximumSubarray{
  public static int maximumSubarrayBrute00(int [] arr)
  {
    int max =arr[0]; //max = Integer.MIN_VALUE
    for(int i=0;i<arr.length;i++)
      {
        int sum = arr[i];
        max=Math.max(sum,max);
        for(int j=i+1;j<arr.length;j++)
          {
            sum=sum+arr[j];
            max=Math.max(sum,max);
          }
      }
    return max;
  }
  public static int maximumSubarrayBrute01(int [] arr)
  {
    int max=Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++)
      {
        int sum = 0;
        for(int j=i;j<arr.length;j++)
          {
            sum+=arr[j];
            max=Math.max(sum,max);
          }
      }
    return max;
  }
  public static void main(String [] args)
  {
    System.out.println("Enter the size of the array ");
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    System.out.println("Enter the values in the array ");
    int [] nums = new int [size];
    for(int i=0;i<size;i++)
      nums[i]=sc.nextInt();
    int max = maximumSubarray(nums);
    System.out.println("The maximum sum of Array is "+max);
  }
}
