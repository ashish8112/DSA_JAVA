import java.util.*;
class FindRepeatingAndMissing{ 
  public static ArrayList<Integer> findTwoElement(int nums[]) {         
    ArrayList <Integer> list = new ArrayList <>();         
    long n = nums.length;         
    long add = n*(n+1)/2;         
    long sum =0;         
    long sq=(n*(n+1)*(2*n+1)/6);        
    long square=0; 
    for(int i=0;i<nums.length;i++)         
    {             
      sum+=nums[i];  
      square=square+(long)nums[i]*nums[i];
    }         
    long first_equation=sum-add;                 
    long second_equation=(int)(square-sq);       
    second_equation=second_equation/first_equation;        
    long duplicate=(first_equation+second_equation)/2;       
    long missing =second_equation-duplicate;        
    list.add((int)duplicate);        
    list.add((int)missing);         
    return list;    
  } 

 public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length of the Array");
    int size = sc.nextInt();
    int [] nums = new int [size];
    System.out.println("Enter the value in the array ");
    for(int i=0;i<size;i++)
      nums[i]=sc.nextInt();
    ArrayList<Integer>list = new ArrayList <>();
    list = findTwoElement(nums);
    System.out.println("Duplicate = "+list.get(0)+" Missing = "+list.get(1));
  }
}
