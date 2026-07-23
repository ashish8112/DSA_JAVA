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

class Solution {
    public int median(int[][] mat) {
        int ans = mat[0][0];
        int low = ans;
        int high = ans;
        for(int i=0;i<mat.length;i++)
        {
          low=Math.min(low,mat[i][0]);
          high=Math.max(high,mat[i][mat[0].length-1]);
        }
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int count =0;
            for(int i=0;i<mat.length;i++)
            {
                for(int j=0;j<mat[0].length;j++)
                {
                    if(mat[i][j]<=mid)
                    count++;
                }
            }
            if(count>(mat.length*mat[0].length/2))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}

class Solution {
    public int median(int[][] mat) {
        int ans = mat[0][0];
        int low = ans;
        int high = ans;
        for(int i=0;i<mat.length;i++)
        {
          low=Math.min(low,mat[i][0]);
          high=Math.max(high,mat[i][mat[0].length-1]);
        }
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int count =0;
            for(int i=0;i<mat.length;i++)
            {
                int small = 0;
                int big = mat[0].length-1;
                int index =big+1; //for upper bound.
                while(small<=big)// we need to count number of values which is less or equall to mid value, we may think why eqaull to mid if we want only smaller values 
        //why not only element which is smaller than mid value so answer that suppose array is like 9 9 9 and median is 9 if we exculude we may get 0 element so we would not able to 
                    //find median so include equall and we may remove not median element using upper bound using count > n*m/2 and going left to that 
                {
                    int imid= small+(big-small)/2;
                    if(mat[i][imid]>mid) 
                    {
                        index=imid;
                        big = imid-1;
                    }
                    else{
                        small=imid+1;
                    }
                }
                count+=index;
            }
            if(count>(mat.length*mat[0].length/2))// upper bound way help's to not validate mid is existing element or not 
            {
                ans=mid;// this may be median so we go left because count is greater than half which is mid part of values called median, because we know median has n*m/2 number of values in left means small values so it greater means that me be just right side of smaller values which may be median that's what is upper bound is.
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}
