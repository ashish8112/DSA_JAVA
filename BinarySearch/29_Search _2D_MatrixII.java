class Solution { // Brute Force
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            if(matrix[i][j]==target)
            return true;
        }
        return false;
    }
}

class Solution { // Better Approach
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++)
        {
            int low=0;
            int high = matrix[i].length-1;
            while(low<=high)
            {
                int mid = low+(high-low)/2;
                if(matrix[i][mid]==target)
                return true;
                else if (matrix[i][mid]<target)
                low=mid+1;
                else 
                high = mid -1;
            }
        }
        return false;
    }
}
