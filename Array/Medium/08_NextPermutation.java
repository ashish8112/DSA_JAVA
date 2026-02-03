import java.util.Scanner;
class NextPermuation{
  public void nextPermutationMessy(int[] arr) {
        int pivot =-1;
        int max = Integer.MAX_VALUE;
        int pos_max=-1;
        int el =0,flag=0;
        for(int i=arr.length-1;i>0;i--)
        {
            if(arr[i-1]<arr[i])
            {
                pivot = i-1;
                el = arr[i-1];
                flag=1;
                break;
            }
        }
        if(flag==1)
        {
            for(int i=arr.length-1;i>pivot;i--)
            {
                if(arr[i]>el)
                {
                    pos_max=i;
                    break;
                }
            }
            int temp = arr[pivot];
            arr[pivot]=arr[pos_max];
            arr[pos_max]=temp;
            int n = arr.length-1;
            pivot++;
            while(pivot<n)
            {
                temp = arr[n];
                arr[n]=arr[pivot];
                arr[pivot]=temp;
                pivot++;
                n--;
            }            
        }
        else {
            int n = arr.length-1;
            pivot = 0;
            while(pivot<n)
            {
                int temp = arr[n];
                arr[n]=arr[pivot];
                arr[pivot]=temp;
                pivot++;
                n--;
            }
        }
    }
public static void reverse (int [] arr,int low,int high)
    {
        while(low<high)
        {
            int temp = arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
        return;
    }
    public static void swap(int [] arr,int index,int max)
    {
        int temp = arr[index];
        arr[index]=arr[max];
        arr[max]=temp;
        return;
    }
    public static void nextPermutation(int[] arr) {
        int index =-1;
        for(int i=arr.length-1;i>0;i--)
        {
            if(arr[i-1]<arr[i])
            {
                index=i-1;
                break;
            }
        }
        if(index==-1)
        {
            reverse(arr,0,arr.length-1);
            return;
        }
        int max=-1;
        for(int i =arr.length-1;i>index;i--)// we need to search  from the last of array that which first element is larger than this pivot element 
        //because wen need just larger number that current permutation number which can be done by the first largest number from the pivot number from the last.
        {
            if(arr[i]>arr[index])
            {
                max=i;
                break;
            }
        }
        swap(arr,index,max);
        reverse(arr,index+1,arr.length-1);
    }
  public static void main(String [] args)
  {
    System.out.println("Enter the size of the array");
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] arr = new int [size];
    System.out.println("Enter the values in the array");
    for(int i=0;i<arr.length;i++)
      arr[i]=sc.nextInt();
    arr = nextPermutation(arr);
    System.out.println("Next permutation of the array is ");
    for(int i=0;i<arr.length;i++)
      System.out.print(arr[i]+" ");
  }
}
