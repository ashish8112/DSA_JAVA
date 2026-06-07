class Solution { // Brute Force
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                 if(matrix[i][j]==target)
                return true;
            }
        }
        return false;
    }
}
class Solution {    //Optimal Approach
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low =0;
        int high = (row*col)-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(matrix[mid/col][mid%col]==target)
            return true;
            else if(matrix[mid/col][mid%col]<target)
            low=mid+1;
            else
            high = mid-1;
        }
        return false;
    }
}
