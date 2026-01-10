package DSA.Array.Medium;
import java.util.*;
public class TwoSum {
    public static int [] indices(int [] arr,int target)
    {
        int [][] numberwithindex = new int [arr.length][2];
        for(int i=0;i<arr.length;i++)
        {
            numberwithindex[i][0]=arr[i];
            numberwithindex[i][1]=i+1;
        }
        Arrays.sort(numberwithindex,(a,b)->Integer.compare(a[0],b[0]));
        int low=0;
        int high=arr.length-1;
        while(low<high)
        {
            if(numberwithindex[low][0]+numberwithindex[high][0]==target)
                return new int []  {numberwithindex[low][1],numberwithindex[high][1]};
            else if (numberwithindex[low][0]+numberwithindex[high][0]<target)
                low++;
            else
                high--;
        }
        return new int [] {-1,-1};
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array ");
        int size=sc.nextInt();
        int [] arr= new int [size];
        System.out.println("Enter the values in the array ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the target to search the indices ");
        int target = sc.nextInt();
        int [] arr2=indices(arr,target);
        if(arr2[0]!=-1)
        {
            System.out.println("Indices of two sum of target "+target+" is below ");
            for(int i=0;i<arr2.length;i++)
                System.out.print(arr2[i]+" ");
                System.out.print(" "+target);
        }
        else
            System.out.println("Indices of two sum of target "+target+" is not found");
    }
}
