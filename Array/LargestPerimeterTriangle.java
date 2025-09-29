package DSA.Array;

import java.util.Arrays;
import java.util.Scanner;
// To check valid triangle from 3 sides , it is necessary that sum of two side is greater than third side.
//a+b>c;
//and
//a+c>b;
//and
//b+c>a;
//all three must satisfy means any sum of two side must be larger than 3rd one.
//
//so my approach is to sort entire array in descending order like for (2,1,2)
//->2,2,1
//I have sorted array in descending because I need to send largest perimeter so it can be found from first three element and  if it is then there is no need to
//check all elements till end .
//because if in first 3 element it is possible to create the triangle then , that would be the largest perimeter of triangle because that 3 elements are
//largest among all the remaining elements in the array.
//note because of descending sorting
//a>=b>=c . then a+b>c always . suppose 2 1 1 then 2+1>1 or 2 2 2 then -> 2+2>2
//a+c>b because -> a may be same as b then a+c>b is bigger or if a is already larger than b , then is obvious that a +c >b.
//**only b+c > a condition is suspicious so we need to check that only so we can conclude that it can form triangle.
class LargestPerimeterTriangle{
     static int largestPerimeterTriangle(int [] arr)
     {
         Arrays.sort(arr);
         int start=0;
         int end=arr.length-1;
         while(start<end) // Now array is Descending Order
         {
             int temp=arr[end];
             arr[end]=arr[start];
             arr[start]=temp;
             start++;
             end--;
         }
         for(int i=0;i<=arr.length-3;i++)
         {
             if(arr[i+1]+arr[i+2]>arr[i])// Need to check that sum of two sides must greater than third side.
             {
                 return arr[i+1]+arr[i+2]+arr[i];
             }
         }
         return 0;
     }
     //In second there is no need to reverse or make sorted array into descending order we can do same thing from last of element
    // because from last it will be descending .
    static int maximumPerimeterTriangle(int [] arr)
    {
        Arrays.sort(arr);
        for(int i=arr.length-3;i>=0;i--)
        {
            if(arr[i]+arr[i+1]>arr[i+2])
            return arr[i]+arr[i+1]+arr[i+2];
        }
        return 0;
    }
     public static void main(String [] args)
     {
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter the size of Array");
         int size=sc.nextInt();
         int [] arr= new int[size];
         System.out.println("Enter the elements in the Array");
         for(int i=0;i<size;i++)
            arr[i]=sc.nextInt();
         System.out.println("Enter the Choice of Approach either 1 or 2");
         int approach=sc.nextInt();
         int perimeter;
         if(approach==1) {
             perimeter = largestPerimeterTriangle(arr);
             if (perimeter != 0)
                 System.out.println("Maximum perimeter of Triangle is = " + perimeter);
             else
                 System.out.println("Triangle is Not possible these array elements");
         }
         else if(approach==2)
         {
             perimeter = maximumPerimeterTriangle(arr);
             if (perimeter != 0)
                 System.out.println("Maximum perimeter of Triangle is = " + perimeter);
             else
                 System.out.println("Triangle is Not possible these array elements");
         }
         else{
             System.out.println("Enter the correct approach either 1 or 2");
         }
     }
}
