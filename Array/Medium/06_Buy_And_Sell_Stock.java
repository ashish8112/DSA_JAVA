import java.util.*;
class Buy_And_Sell_Stock{
  public int maxiProfitBrute(int [] arr)
  {
    int min=Integer.MAX_VALUE;
    int profit=0;
    for(int i=0;i<arr.length;i++)
      {
        if(arr[i]<min)
        {
          int j=i+1;
          while(j<arr.length)
            {
              if(arr[j]>arr[i]&&arr[j]-arr[i]>profit)
              {
                profit=arr[j]-arr[i];
                min=arr[i];
              }
            }
        }
      }
    return profit;
  }
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array");
    int size = sc.nextInt();
    int [] arr = new int [size];
    System.out.println("Enter the values in the array");
    for(int i=0;i<arr.length;i++)
      {
        arr[i]=sc.nextInt();
      }
    
  }
}
