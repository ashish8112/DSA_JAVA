import java.util.*;
public class OwnException{
public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the maks in scorecard");
	int arr[]=new int[20];
	for(int i=0;i<20;i++)
	{
	int number;
	try{
	System.out.println("Enter the "+(i+1)+" number in scorecard");
	number=sc.nextInt();
		if(number>100||number<0)
		{
			throw new IllegalArgumentException("Marks must be between 0 and 100.");
			
			
		}
		arr[i]=number;
	}
		catch (IllegalArgumentException e)
		{
			 System.out.println("Invalid input: " + e.getMessage());
                		 i--;
		}
		
	}		

		System.out.println("\tScorecard of person X is below : ");
		for(int i=0;i<20;i++)
		System.out.println("\t\t"+(i+1)+" Number is = "+arr[i]);
	}
	}
		
