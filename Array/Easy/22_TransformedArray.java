import java.util.*;
class TransformedArray{
  public static int[] constructTransformedArray(int[] nums) {
        int [] arr = new int [nums.length];
        for(int i=0;i<nums.length;i++)
        {
           int shift =Math.abs(nums[i])%nums.length;
            if(nums[i]<0)
            {
                arr[i]=nums[(i-shift+nums.length)%nums.length];
            }
            else 
            {
                arr[i]=nums[(i+shift)%nums.length];
            }
        }
        return arr;
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
    shuffle(arr);
    for(int i=0;i<size;i++)
      {
        System.out.prinl(arr[i]+" ");
      }
  }
}
