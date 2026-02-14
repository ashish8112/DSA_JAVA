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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row ");
        int row = sc.nextInt()-1;
        System.out.println("Enter the col");
        int col = sc.nextInt()-1;
       solveNcR(row,col);
    }
}
