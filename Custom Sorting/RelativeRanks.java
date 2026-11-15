class Solution {
    public String[] findRelativeRanks(int[] score) {
     int [][] rank = new int [score.length][2];
     for(int i=0;i<score.length;i++)
     rank[i]=new int [] {score[i],i};
     Arrays.sort(rank,(a,b)->{ // or Arrays.sort(rank,(a,b)->b[0]-a[0]);
        return b[0]-a[0];
     });
     String [] result = new String[score.length];
     for(int i=0;i<score.length;i++)
     {
        if(i==0)
        result[rank[i][1]]="Gold Medal";
        else if(i==1)
        result[rank[i][1]]="Silver Medal";
        else if(i==2)
        result[rank[i][1]]="Bronze Medal";
        else
        result[rank[i][1]]=String.valueOf(i+1);
     }
     return result;
    }
}
