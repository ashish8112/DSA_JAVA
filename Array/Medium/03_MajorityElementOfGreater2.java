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

    public static int [] majorityElementOfGreat2Op(int [] arr)
    {
        int max=0;
        int number=0;
        ArrayList<Integer> num = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            int flag=0;
            int count =0;
            if(num.isEmpty()){
                num.add(arr[i]);
                for(int j=0;j<arr.length;j++)
                {
                    if(arr[i]==arr[j])
                        count++;
                }
                if(max<count)
                {
                    max=count;
                    number=arr[i];
                }
                flag=1;
            }
            else {
                int k=num.size()-1;
                while(k>=0)
                {
                    if(arr[i]==num.get(k))
                    {
                        flag=1;
                        break;
                    }
                    k--;
                }
            }
            if(flag==0){
                num.add(arr[i]);
                for(int j=0;j<arr.length;j++)
                {
                    if(arr[i]==arr[j])
                        count++;
                }
                if(max<count)
                {
                    max=count;
                    number=arr[i];
                }
            }
        }
        return new int [] {number,max};
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
        int [] number= majorityElementOfGreat2Op(arr);
        System.out.print("NUmber "+number[0]+" repeats "+number[1]+" times");
    }

}
