class Solution {
    public int rowWithMax1s(int[][] arr) {
         int index =-1;
         int maxOne =0;
         for(int i=0;i<arr.length;i++)
         {
             int low =0;
             int high = arr[i].length-1;
             int ans = arr[0].length;
             while(low<=high)
             {
                 int mid= low +(high-low)/2;
                 if(arr[i][mid]==1)
                 {
                     ans = mid;
                     high = mid-1;
                 }
                 else
                 low=mid+1;
             }
             int count = arr[i].length-ans;
             if(count>maxOne)
             {
                 index=i;
                 maxOne=count;
             }
         }
         return index;
    }
};
