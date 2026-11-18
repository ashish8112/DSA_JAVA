class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int [][] soldiers = new int [mat.length][2];
        for(int i=0;i<mat.length;i++)
        {
            int count = 0;
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                count++;
            }
            soldiers[i] = new int [] {count,i};
        }
        Arrays.sort(soldiers,(a,b)->a[0]-b[0]);
        int [] ans = new int [k];
        for(int i=0;i<k;i++)
        {
            ans[i]=soldiers[i][1];
        }
        return ans;
    }
}
