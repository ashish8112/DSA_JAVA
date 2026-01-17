package DSA.Array.Medium;
import java.util.*;
class MajorityElementNBy2 {
    public static int [] majorityElementI_Brute(int [] arr) // Brute Force
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
    public static int majortityI_Better(int [] arr) // Better Approach 
    {
        Arrays.sort(arr);
        int el=0,max=0,count=0,cand=0;
        if(arr.length>0)
            el=arr[0];
        for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==el)
                    count++;
                else {
                    if(count>max)
                    {
                        cand=el;
                        max=count;
                    }
                    el=arr[i];
                    count=1;
                }
            }
        if(count>max)
        {
            cand=el;
            max=count;
        }
        if(max>arr.length/2)
        return cand;
        else 
        return -1; // Although question has stated as confirmed majority element , I have done this if it doesn't exists.
    }
    public static int majorityElementMoore(int [] arr) // Original Moore voting method.
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
    public static int majorityI_Op2(int [] arr) // Optimal Solution 2
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
        int  number= majorityElementMoore(arr);
        System.out.print("NUmber "+number+" is majority element >N/2"); // Note in question it is confirmed that majority Element will exist.
    }
}
