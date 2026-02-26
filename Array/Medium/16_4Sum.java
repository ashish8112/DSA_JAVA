import java.util.*;
class FourSum{
    public static List<List<Integer>> fourSum(int[] nums, int target) {
      List <List <Integer>>list = new ArrayList<>();
      Arrays.sort(nums);
      for(int i=0;i<nums.length-3;i++)
      {
        if(i>0&&nums[i]==nums[i-1])
        continue;
        for(int j=i+1;j<nums.length-2;j++)
        {
            if(j>i+1&&nums[j]==nums[j-1])
            continue;
            int left = j+1;
            int right = nums.length-1;
            while(left<right)
            {
                long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];
                if(sum==target)
                {
                    list.add(Arrays.asList(nums[i],nums[j],nums[left++],nums[right--]));
                    while(left<right&&nums[left]==nums[left-1])left++;
                    while(left<right&&nums[right]==nums[right+1])right--;
                }
                else if(sum<target)
                left++;
                else
                right--;
            }
        }
      }
      return list;  
    }
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length of the Array ");
    int size = sc.nextInt();
    System.out.println("Enter the values in the array ");
    int [] arr = new int[size];
    for(int i=0;i<size;i++)
      arr[i]=sc.nextInt();
    System.out.println("Enter the target for 4sum ");
    int target = sc.nextInt();
    List<List<Integer>>list = new ArrayList<>();
    list =  fourSum(arr,target);
    System.out.println(list);
  }
}
