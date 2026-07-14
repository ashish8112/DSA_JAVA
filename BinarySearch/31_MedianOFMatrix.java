class Solution { //brute force
    public int median(int[][] mat) {
        int [] arr = new int [mat[0].length*mat.length];
        int k=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                arr[k++]=mat[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
}
