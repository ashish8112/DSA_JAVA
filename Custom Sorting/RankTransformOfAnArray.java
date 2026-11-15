class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int [][] pairs = new int [arr.length][2];
        for(int i=0;i<arr.length;i++)
        pairs[i]=new int[]{arr[i],i};
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int [] rank = new int [arr.length];
        int count = 1;
        for(int i=0;i<rank.length;i++)
        {
            if(i!=0) // instead this see below code 
            {
                if(pairs[i][0]==pairs[i-1][0])
                rank[pairs[i][1]]=count-1;
                else
                rank[pairs[i][1]]=count++;
            }
            else{
                 rank[pairs[i][1]]=count++;
            }
           
        }
        return rank;
    }
}

class SolutionCleanedOnly {
    public int[] arrayRankTransform(int[] arr) {
        int [][] pairs = new int [arr.length][2];
        for(int i=0;i<arr.length;i++)
        pairs[i]=new int[]{arr[i],i};
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int [] rank = new int [arr.length];
        int count = 0;
        for(int i=0;i<rank.length;i++)
        {
           if(i==0||pairs[i][0]!=pairs[i-1][0])
           count++;
           rank[pairs[i][1]]=count;
           
        }
        return rank;
    }
}

// Time Complexity : O(N Log N)
// Space Complexity : O(N)
