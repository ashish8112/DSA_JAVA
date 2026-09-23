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

class Solution { //Optimal Approach
    public double pow(double x,long n){
        if(n==0)
        return 1;
        if(n<0)
        return pow(1/x,-n);
        if(n%2==0)
        return pow(x*x,n/2);
        return x*pow(x*x,(n-1)/2);
    }
    public double myPow(double x, int n) {
        if(n==0||x==1)
        return 1;
        return pow(x,n);
    }
}
//Time Complexity = O(log n) => power is getting half everytime and recursive method is called only log (pow time) 
//Space complexity = O(log n) => because recursion stack
