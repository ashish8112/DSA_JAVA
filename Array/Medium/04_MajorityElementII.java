package DSA.Array.Medium;

import java.util.*;

 class MajorityElementII {
    public static List<Integer> majorityN2(int [] arr) // BruteForce
    {
        List <Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {int count1=0;
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                    count1++;
                if(count1>arr.length/3) {
                    if(!list.contains(arr[i])) {
                        list.add(arr[i]);
                        break;
                    }
                }
            }
        }
        return list;
    }
    public static List<Integer> majorityN2Op(int [] arr)
    {
        List <Integer> list = new ArrayList<>();
        int el1=0,el2=0,count1=0,count2=0;
        for(int i=0;i<arr.length;i++)
        {
            if(el1==arr[i])
                count1++;
            else if(el2==arr[i])
                count2++;
            else if (count1==0)
            {
                el1=arr[i];
                count1++;
            }
            else if(count2==0)
            {
                el2=arr[i];
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        } count1=0;count2=0;
        for(int i=0;i<arr.length;i++)
        {
            if(el1==arr[i])
                count1++;
            else if(el2==arr[i])
                count2++;
        }
        if(count1>arr.length/3)
            list.add(el1);
        if(count2>arr.length/3)
            list.add(el2);
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array to check n/2 repeating element in the array ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the values in the array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        List <Integer> numbers = majorityN2Op(arr);
        System.out.println(numbers);
    }
}