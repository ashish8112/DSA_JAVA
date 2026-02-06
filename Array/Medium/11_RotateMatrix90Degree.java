import java.util.*;
class RotateImage {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) // first I transpose the enitre matrix by swapping upper traingluar matrix which is above the diagnoal with lower triangular matrix which down the diagonal.
        {
            for(int j=i+1;j<matrix[0].length;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++) // then reverse the entire array from right to left and vice versa.
        {
            int k=i;
            int l=matrix[0].length-1;
            for(int j=0;j<matrix[0].length;j++)
            {
                if(j<l)
                {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[k][l];
                matrix[k][l--]=temp;
                }
                else 
                break;
            }
        }
    }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner (System.in);
    System.out.println("Enter the row size and col size respectively ");
    int row= sc.nextInt();
    int col = sc.nextInt();
    int [][] matrix = new int [row][col];
    System.out.println("Enter the values in the matrix ");
    for(int i=0;i<row;i++)
      {
        for(int j=0;j<col;j++)
          {
           matrix[i][j]=sc.nextInt();
          }
      }
    rotate(matrix);
    for(int i=0;i<row;i++)
      {
        for(int j=0;j<col;j++)
          {
           System.out.print(matix[i][j]+" ");
          }
        System.out.println();
  }
}
