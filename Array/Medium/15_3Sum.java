import java.util.*;
class _3Sum{
  public static List<List<Integer>> threeSum(int[] arr)
  {
    List<List<Integer>>list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++)
        {
            if(i>0&&arr[i]==arr[i-1]) // to skip same elements .
            continue;
            if(arr[i]>0) // Because the target is always 0, and after sorting, if we perform 3Sum with the first element greater than 0, we cannot get a sum of 0.
            break;  //  So break the loop. The array is sorted, so all remaining elements will also be greater than 0.
            int left = i+1;
            int right =arr.length-1;
            while(left<right)
            {
                int sum = arr[i]+arr[left]+arr[right];
                if(sum == 0)
                {
                    list.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;right--;
                    while(left<right&&arr[left]==arr[left-1])// Skip duplicate elements for the left pointer
                    left++;
                    while(left<right&&arr[right]==arr[right+1]) // Skip duplicate elements for the right pointer , Since the array is sorted, if left increases, 
                    right--;                                //the sum also increases. So it is not possible to get the same sum (0) with the current right value.
                }
                else if(sum<0)
                left++;
                else
                right--;
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
    List<List<Integer>>list = new ArrayList<>();
    list =  threeSum(arr);
    System.out.println(list);
  }
}
