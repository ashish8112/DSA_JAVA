package DSA.Array.Medium;
import java.util.*;
class MajorityElementOfGreater2 {
    public static int [] majorityElementOfGreat2(int [] arr) // Brute Force
    {
        int number=0;
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            int count =0;
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                    count++;
            }
            if(count>max)
            {
                max=count;
                number=arr[i];
            }
        }
        return new int []{number,max};
    }
    public static int majority2N2(int [] arr)
    {
        int count=0,el=0;
        for(int i=0;i<arr.length;i++)
        {
            if(count==0)
            {
                el=arr[i];
                count++;
            }
            else if(arr[i]!=el)
                count--;
            else
                count++;
        }
        return el;
    }
    public static int majorityN2(int [] arr) // Optimal Solution 2
    {
        int count=0,el=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==el)
                count++;
            else if(count==0)
            {
                el=arr[i];
                count++;
            }
            else if(arr[i]!=el)
                count--;
            else
                count++;
        }
        return el;
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the size of the array to check n/2 repeating element in the array ");
        int size=sc.nextInt();
        int [] arr= new int [size];
        System.out.println("Enter the values in the array ");
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        int  number= majorityN2(arr);
        System.out.print("NUmber "+number+" is majority element I which has frequency of >N/2");
    }
}
