import java.util.*;
class MergeIntervals{
   public static int[][] merge(int[][] arr) {
        //Note start<=end for any interval 
        int [][] result = new int [arr.length][2];
        if(arr.length<2)
        {
            return arr;
        }
        int k=-1;
        Arrays.sort(arr,(a,b) -> a[0]-b[0]);//Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<arr.length;i++)
        {
            if(k==-1)
            {
             result[++k][0]=arr[i][0];
             result[k][1]=arr[i][1];  
            }
            else if(arr[i][0]<=result[k][1])
            {
                result[k][1]=Math.max(arr[i][1],result[k][1]);
            }
            else{
                result[++k][0]=arr[i][0];
                result[k][1]=arr[i][1];
            }
        }
        return Arrays.copyOf(result,k+1);
    }
public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length of the Array in row because column is 2 always");
    int size = sc.nextInt();
    System.out.println("Enter the values in the array ");
    int [][] arr = new int[size][2];
    for(int i=0;i<size;i++)
      {
      arr[i][0]=sc.nextInt();
      arr[i][1]=sc.nextInt();
      }
    arr=merge(arr);
    for(int i=0;i<arr.length;i++)
      {
        System.out.println("["+arr[i][0]+","+arr[i][1]+"]");
      }
  }
}
