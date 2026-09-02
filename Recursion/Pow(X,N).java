class Solution { //Brute force 
    public double myPow(double x, int n) {
        if(n==0||x==1)
        return 1;
        Long N = (long)n;
        double ans = x;
        boolean negative = false;
        if(n<0)
        {
            N=-N;
            negative = true;
        }
        for(int i=1;i<N;i++)
        {
           ans = ans *x;
        }
        if(negative)
        return (double)1/ans;
        return ans;
    }
}

