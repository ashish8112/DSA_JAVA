import java.util.*;
class ArrayIsSortedAndRotated{
  public static boolean checkBrute(int[] nums) { //Brute force -> rotate array n(size of array) times by 1 every time in array and check whether it is sorted or not.
        if(nums.length<2)
        return true;
        int k =0;
        while(k<nums.length)
        {
             int flag =0;
            for(int i=0;i<nums.length-1;i++)
            {
                if(nums[i]<=nums[i+1])
                {
                   flag=1; 
                }
                else{
                    flag=0;
                    break;
                }
            }
            if(flag==1)
            {
                return true;
            }
           int temp = nums[nums.length-1];
            for(int i=nums.length-1;i>=0;i--)
            {   if(i!=0)
                nums[i]=nums[i-1];
                else
                nums[i]=temp;
            }
           
            k++;
        }
        return false;
    }
  public boolean checkBetter(int[] nums) {
        int [] result = nums.clone();
        Arrays.sort(result);
        for(int r=0;r<nums.length;r++)
        { boolean valid = true;;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]!=result[(i+r)%nums.length])
                valid=false;
            }
            if(valid)
            return true;
        }
        return false;
    }
  public static boolean check(int[] nums) {//Optimal-> In Every either it is rotated or not if it was sorted there would be only one dip or change in elements.
        int dip=0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>nums[(i+1)%n])
            dip++;
        }
        if(dip<2)
        return true;
        return false;
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
    boolean condition=check(arr);
    if(condition)
      System.out.println("Array was sorted");
    else
      System.out.println("Array was not sorted");
  }
}
