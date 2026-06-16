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
