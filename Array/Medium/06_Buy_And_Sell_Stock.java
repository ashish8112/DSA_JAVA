import java.util.*;
class Buy_And_Sell_Stock{
  public int maxiProfitBrute(int [] arr) //Brute Approach
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
              j++;
            }
        }
      }
    return profit;
  }
  public int maxiProfitOpt(int [] arr) // Optimal Approach
  {
    int min=arr[0];
    int profit=0;
    for(int i=1;i<arr.length;i++)
      {
        int cost = arr[i]-min;
        profit=Math.max(cost,profit);
        min=Math.min(min,arr[i]);
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
    int profit = maxiProfitOpt(arr);
    System.out.println("Maximum Profit in Selling stock is "+profit);
  }
}
