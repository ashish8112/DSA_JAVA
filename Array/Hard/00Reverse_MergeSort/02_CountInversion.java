import java.util.*;
class CountInversion {
    public static int merge(int [] nums,int low,int high,int count)
    {
        if(low>=high)
        return count;
        int mid = low+(high-low)/2;
        count=merge(nums,low,mid,count);
        count=merge(nums,mid+1,high,count);
        count=mergeSort(nums,low,mid,high,count);
        return count;
    }
    public static int mergeSort(int [] nums, int low , int mid , int high,int count)
    {
        int left = low;
        int right = mid+1;
        ArrayList <Integer> list = new ArrayList<>();
        while(left<=mid&&right<=high)
        {
            if(nums[left]<=nums[right])
            list.add(nums[left++]);
            else
            {
            list.add(nums[right++]);
            count = count + (mid-left+1);
            }
        }
        while(left<=mid)
        {
            list.add(nums[left++]);
        }
        while(right<=high)list.add(nums[right++]);
        for(int i=low;i<=high;i++)
        {
            nums[i]=list.get(i-low);
        }
        return count;
    }
    public static void main(String[] args) {
    System.out.println("Enter the size of the array ");
    Scanner sc = new Scanner (System.in);
    int size = sc.nextInt();
    int [] nums = new int [size];
    for(int i=0;i<size;i++)
    nums[i]=sc.nextInt();
    int count=0;
    count=merge(nums,0,size-1,count);
    for(int i=0;i<size;i++)
    System.out.print(nums[i]+" ");
    System.out.println(count);
    }
}
