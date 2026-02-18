import java.util.*;
class AddToArrayFomrOf_Integer {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int j= nums.length-1;
        int carry=0;
        while(k!=0&&j>=0)
        {
            int rem = k%10;
            int sum = nums[j--]+rem+carry;
            if(sum<10)
            {
            list.add(sum);
            carry=0;
            }
            else{
                sum=sum-10;
                list.add(sum);
                carry=1;
            }
            k=k/10;
        }
        while(k!=0){
           int rem=k%10;
            int sum = carry+rem;
            if(sum<10)
            {
                list.add(sum);
                carry=0;
            }
            else{
                sum=sum-10;
                list.add(sum);
                carry=1;
            }
            k=k/10;
        }
        while(j>=0)
        {
            int sum=nums[j--]+carry;
            if(sum<10)
            {
                list.add(sum);
                carry=0;
            }
            else{
                sum=sum-10;
                list.add(sum);
                carry=1;
            }
        }
        if(carry==1)
        list.add(1);
        Collections.reverse(list);
        return list;
    }
   public List<Integer> addToArrayFormOp(int[] nums, int k) {
        int j= nums.length-1;
        List<Integer>list = new ArrayList<>();
        while(j>=0||k>0)
        {
            if(j>=0)
            {
                k=k+nums[j--];
                list.add(k%10);
            }
            else
            list.add(k%10);//suppose nums={0} , k =256
            k=k/10;
        }
        Collections.reverse(list);
        return list;
    }
  public static void main(String [] args)
  {
     Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array ");
        int size;
        size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the values of the array ");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the number to add");
        int target = sc.nextInt();
        List <Integer> list = new ArrayList<>();
        list = addToArrayFormOp(arr,target);
        System.out.println(list);
  }
}
//Although both code is optimal but readibility can be improved as well all three loop task can be done in 1 loop.
//Logic of Optimal code : is that add entire k with last digit of array not last digit of k 
//store the last digit of sum as we do normal in pen paper
//The remaining part becomes the carry.
//Carry can be obtained by dividing the sum by 10 (sum / 10) ex - 12 + 256 so 2 + 256 = 258 so 8 is digit and 25 is carry.
//Continue this process while there are digits left in the array or k still has digits
////edge case that carry can be there if k is not  0 
//If carry remains after finishing the array, keep processing it the same way.
//Finally, reverse the list because digits were added from last to first
