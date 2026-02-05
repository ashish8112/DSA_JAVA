import java.util.*;
class SetMatrixZeros {
    public void setZeroes(int[][] matrix) { //Better Approach
        boolean [] row = new boolean [matrix.length];
        boolean [] col = new boolean [matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if((row[i])||(col[j]))
                matrix[i][j]=0;
            }   
        }
    }
    public void setZeroesOpt(int[][] matrix) { // Optimal approach .
        boolean row = false;
        boolean col = false ;
        for(int i=0;i<matrix.length;i++)//Marking 0th row 
        {
            if(matrix[i][0]==0)
            {
                row=true;
                break;
            }
        }
        for(int j=0;j<matrix[0].length;j++)
        {
            if(matrix[0][j]==0)
            {
                col = true;
                break;
            }
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[0][j]==0||matrix[i][0]==0)
                matrix[i][j]=0;
            }
        }
        if(col)
        {
            for(int i=0;i<matrix[0].length;i++)
            matrix[0][i]=0;
        }
        if(row)
        {
            for(int i=0;i<matrix.length;i++)
            matrix[i][0]=0;
        }
    }
 public static void main(String [] args)
  {
    System.out.println("Enter the size of row and col in array");
    Scanner sc = new Scanner(System.in);
    int row = sc.nextInt();
    int col = sc.nextInt();
    int [][] arr = new int [row][col];
    System.out.println("Enter the values in the array");
    for(int i=0;i<row;i++)
      {
        for(int j=0;j<col;j++)
          arr[i][j]=sc.nextInt();
      }
    setZeroes(arr);
     for(int i=0;i<row;i++)
      {
        for(int j=0;j<col;j++)
          System.out.println(arr[i][j]+" ");
      }
  }
}
