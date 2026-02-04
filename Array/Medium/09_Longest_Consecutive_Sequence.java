import java.uti.*;
class LongestConsectuive{
    public int longestConsecutive(int[] arr) { // Better Approach
        if(arr.length<1)
        return 0;
        Arrays.sort(arr);
        int count =1,max=0;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]+1==arr[i+1])
            count++;
            else if (arr[i]==arr[i+1])
            continue;
            else {
                max = Math.max(max,count);
                count=1;
            }
        }
        max=Math.max(max,count);
        return max;
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
    int count = longestConsecutive(arr);
    System.out.println("The longest consecutive is "+count);
  }
}
