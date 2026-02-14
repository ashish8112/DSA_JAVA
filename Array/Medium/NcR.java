import java.util.*;
class NcR{
    public static void solveNcR(int row,int col)//We should avoid this because it will lead to int overflow .
  {
     int factr=1;
        int factc=1;
        int r = row-col;
        int fr=1;
        for(int i=row;i>=1;i--)
        {
            factr=factr*i;
            if(i<=col)
            factc=factc*i;
            if(i<=r)
            fr=fr*i;
            
        }
        int value = factr/(fr*factc);
        System.out.println("Value of Nth col of Nth row is "+value);
  }
     public static void impr(int row,int col) // Optimal Approach for finding NcR
  {
      int value =1;
      for(int i=0;i<col;i++)
      {
        value = value*(row--);//ex-> 5c2 = (5 * 4)Numerator && (2 * 1)Denominator so 5/2 will cause inconsisent in Integer(int) so 5/1 -> 4/2  5*2=10.
        value = value/(i+1);
      }
      System.out.println("Value of Nth col of Nth row is "+value);
  }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row ");
        int row = sc.nextInt()-1;
        System.out.println("Enter the col");
        int col = sc.nextInt()-1;
       solveNcR(row,col);
    }
}
