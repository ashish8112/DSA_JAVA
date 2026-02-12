import java.util.*;
class SprialMatrix{
  public List<Integer> spiralOrder(int[][] matrix) {
        List <Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length-1;
        int top =0;
        int bottom =matrix.length-1;
        while(top<=bottom && left<=right)
        {
           for(int i=left;i<=right;i++)
           result.add(matrix[top][i]);
           top++;
           for(int i=top;i<=bottom;i++)
           result.add(matrix[i][right]);
           right--;
           if(top<=bottom) // when there is only single row in matrix 
           {
            for(int i=right;i>=left;i--)
            result.add(matrix[bottom][i]);
            bottom--;
           } 
           if(left<=right) // when there is only single column in matrix.
           {
            for(int i=bottom;i>=top;i--)
            result.add(matrix[i][left]);
            left++;
           }
        }
        return result;
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
    List <Integer>result = new ArrayList<>();
    result=spiralOrder(matrix);
    System.out.println(result);
}
}
