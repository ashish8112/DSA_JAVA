class Solution { //Brute Force
    public int[] findPeakGrid(int[][] matrix) {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(i>0&&matrix[i][j]<matrix[i-1][j])
                continue;
                else if(i<matrix.length-1&&matrix[i][j]<matrix[i+1][j])
                continue;
                else if(j>0&&matrix[i][j]<matrix[i][j-1])
                continue;
                else if(j<matrix[0].length-1&&matrix[i][j]<matrix[i][j+1])
                continue;
                else
                return new int [] {i,j};
            }
        }
         return new int [] {-1,-1};
    }
}

class Solution { //Optimal
    public int[] findPeakGrid(int[][] matrix) {
    int low =0;
    int high = matrix[0].length-1;
    int row =0;
    while(low<=high)
    {
        int col = low+(high-low)/2;
        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[row][col]<matrix[i][col])
            row=i;
        }
        if(col<matrix[0].length-1&&matrix[row][col]<matrix[row][col+1])
        {
            low=col+1;
            continue;
        }
        if(col>0&&matrix[row][col]<matrix[row][col-1])
        {
            high = col-1;
            continue;
        }
        return new int [] {row,col};
    }
        return new int [] {-1,-1};
    }
}
