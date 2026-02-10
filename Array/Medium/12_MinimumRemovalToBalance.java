import java.util.*;
class MinimumRemovalsToBalanceArray{
   public int minRemoval(int[] nums, int k) { //LeetCode 3634
        Arrays.sort(nums);
        int i =0,j=0;
        int length =0;
        while(i<nums.length&&j<nums.length)
        {
            int min = nums[i];
            int max = nums[j];
            if(max<=(long)min*k)
            {
                length=Math.max(length, j-i+1);
                j++;
            }
            else {
                i++;
            }
        }
        return nums.length-length;
    }
public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length of the array /Give in Even number ");
    int size = sc.nextInt();
    System.out.println("Enter the value in the array ");
    int [] arr = new int [size];
    for(int i=0;i<size;i++)
     arr[i]=sc.nextINt();
    System.out.println("Enter the Integer to balance on that ");
    int k = sc.nextInt();
    int length=minRemoval(arr,k);
    system.out.println("Number of element need to removed to make this array balance is "+length);
  }
}
