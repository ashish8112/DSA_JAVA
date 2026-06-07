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

class Solution { // Better Approach 
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++)
        {
            int low =0;
            int high = matrix[i].length-1;
                if(target>=matrix[i][low]&&target<=matrix[i][high])
                {
                     while(low<=high)
                     {
                        int mid = low+(high-low)/2;
                        if(matrix[i][mid]==target)
                        return true;
                        else if(matrix[i][mid]>target)
                        high=mid-1;
                        else
                        low=mid+1;
                     }
                }
        }
        return false;
    }
}
//Time complexity : O(n+logm) why not * because logm means while loop only executing one time and if condition is true and only on columns.

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

// Think of 2d matrix as virtual entire 1d matrix
// example [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
            // 1  3  5  7  10  11  16  20  23  30  34  60 
Virtual index  0  1  2  3  4   5   6   7   8   9  10   11
// high = r*col - 1 => 3 * 4 = 12 -1 = 11 
// because as we know in 1d array also array.length is entire length 12 if it is 1d but last index is 12-1 
    // and now we can calculate the correct index using mid if low =0 and high =11 
// suppose we are creating circular queque so what we index+1%arr.length to get 0 th location if we are at end 
// that's how there are 4 column in each row so we can get col index using mid%col for example 7th virtual index but original index is 13 
    // if we take remainder of 7%4 we get 4 = 3 and now how row .. think like we are adding 4 element's array together and there are 4 array in a line 
    // if 4 element complete means 0th array is completed andn  1st array is started that how we get row index  *virtualIndex/col* why col because 
    // each array is consist of col number of value in a each array so if number entirely divided we get the position of that index , that where it is 
    // stored in 0th array , 1st array or so on 
    // like we have 4 bucket of limit 4L so if we want to store 13th liter where we can store 13/4 = 2th bucket if indexing start's from 0 

// that why we get row index using *quotient* correctRowIndex = VirtualIndex/col
//                 col index using *remainder* correctRowIndex = VirtualIndex%col
