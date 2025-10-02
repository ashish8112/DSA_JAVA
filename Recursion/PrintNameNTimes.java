package DSA.Recursion;

import java.util.Scanner;

public class PrintNameNTimes {
    void printNameNTimes(String name,int i,int n)
    {
        if(i>n)
            return;
        System.out.println(name);
          printNameNTimes(name,i+1,n);
    }

    public static void main(String[] args) {
        PrintNameNTimes obj=new PrintNameNTimes();
        Scanner sc= new Scanner(System.in);
        String name=sc.nextLine();
       obj.printNameNTimes(name,1,5);
    }
}
