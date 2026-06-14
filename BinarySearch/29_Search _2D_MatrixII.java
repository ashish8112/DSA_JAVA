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

class Solution { // Optimal Approach 
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;
        while(row<matrix.length&&col>=0)
        {
            if(matrix[row][col]==target)
            return true;
            else if(matrix[row][col]<target)
            row++;
            else
            col--;
        }
        return false;
    }
}

// Pattern : Staircase Search — 2D Matrix
// what is question each row is sorted in ascending order but columns are sorted in ascending order too 
// that means last value of 1st row is not may be smaller then 1st value of second row because see question 
// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
        1    4    7    11    15  <- it is sorted in ascending order 
        2    5    8    12    19  and columns are also sorted in ascending 
        3    6    9    16    22
        10   13   14   17    24
        18   21   23   26    30
// core idea is to start form top right corner as it is largest in first row , if currentIndex value is the target value return true or if current value is larger than target
// then move pointer from currentIndex to one previous one why because all elements in that column will be larger than current value so move left 
// and if currentIndex value is smaller than target then move pointer to next row from 0th row to 1st row because element is greater than that in next row column , now we can think
// why next row , why not current row and move right side as greater element is also in right side of that current index because we are here after checking that row as we are coming 
// form top right corner so we moved left because those values were greater than target value 
