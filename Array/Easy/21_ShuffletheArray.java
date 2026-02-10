import java.util.*;
class ShuffletheArray{
public int[] shuffle(int[] nums, int n) { //Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].              
        int [] result = new int[nums.length]; //Return the array in the form [x1,y1,x2,y2,...,xn,yn].
        int j =n;
        for(int i=0;i<n;i++)
        {
            result[i*2]=nums[i];
            result[i*2+1]=nums[j++];
        }
        return result;
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
    arr = shuffle(arr,size/2);
    for(int i=0;i<size;i++)
      {
        System.out.prinl(arr[i]+" ");
      }
  }
}
