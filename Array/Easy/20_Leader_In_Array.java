import java.util.*;
class LeaderInArray{
static ArrayList<Integer> leaders(int arr[]) {
        int max = arr[arr.length-1];
        ArrayList <Integer> Leader = new ArrayList <>();
        Leader.add(max);
        for(int i=arr.length-2;i>=0;i--)
        {
           if(arr[i]>=max)
           {
               Leader.add(arr[i]);
               max = arr[i];
           }
        }
         Collections.reverse(Leader);
        return Leader;
    }
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array ");
    int  size = sc.nextInt();
    int [] arr = new int [size];
    System.out.println("Enter the values in the array ");
    for(int i=0;i<arr.length;i++)
      arr[i]=sc.nextInt();
    ArrayList <Integer> leader = new ArrayList<>();
    leader = leaders(arr);
    System.out.println(leader);
  }
}
