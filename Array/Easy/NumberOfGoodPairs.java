import java.util.*;
class NumberOfGoodPairs{
   public static int numIdenticalPairs(int[] nums) { 
        Arrays.sort(nums);
        int count=1;
        int max=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
            count++;
            else 
            {
                count=count*(count-1)/2; //Ncr for finding number of unique pair from number like 1 1 1 3c2 3 
                max=max+count;
                count=1;
            }
        }
        count=count*(count-1)/2;
        max=max+count;
        return max;
    }
  public static int numIdenticalPairsManual(int [] nums) // Manually reading pairs. 
  {
     Arrays.sort(nums);
        int count=0;
        int j=0;
        int i=j+1;
        while(j<nums.length-1)
        {
            if(nums[j]==nums[i])
            {
                count++;
                i++;
                if(i==nums.length)
                {
                    j++;
                    i=j+1;
                }
            }
            else {
                j++;
                i=j+1;
            }
        }
        return count;
  }
  public static void main(String [] args)
  {
     System.out.println("Enter the size of the array");
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] arr = new int [size];
    System.out.println("Enter the values in the array");
    for(int i=0;i<arr.length;i++)
      arr[i]=sc.nextInt();
    int pairs = numIdenticalPairs(arr);
    System.out.println("Number of good pairs = "+pairs);
  }
}
