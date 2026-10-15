class Solution {
    public long modPow(long base, long exponent , long MOD)
    {
        if(exponent == 0)
        return (long) 1;
        if(exponent == 1)
        return base;
        if(exponent%2==0)
        return modPow((base*base)%MOD,exponent/2,MOD);
        return (base * modPow((base*base)%MOD,exponent/2,MOD)%MOD);
    }
    public int countGoodNumbers(long n) {
        final long MOD = (long)(1e9+7); //Note 1e9 = > 1* 10 ^9 and 10e9 => 10 * 10^9 because e means base 10 or use final long MOD = 1_000_000_007L;
        long even = (n+1)/2;
        long odd = n - even;
        even = modPow(5,even,MOD);
        odd = modPow(4,odd,MOD);
        return (int)((even*odd)%MOD);
    }
}
//Time complexity = O(log n)
//Space complexity = O(log n)


class Solution { // Same But Instead of Recursion used iterative for exponent
     public long myPow(long x,long N) {
        if(N==0||x==1)
        return 1;
        final long MOD = (long)(1e9+7);
        long currentProduct = x,answer =1;
        while(N>0)
        {
            if(N%2!=0)
            answer = (answer*currentProduct)%MOD;
            currentProduct=(currentProduct*currentProduct)%MOD;
            N/=2;
        }
        return answer;
    }
    public int countGoodNumbers(long n) {
        final long MOD = (long)(1e9+7);
        long even = (n+1)/2;
        long odd = n - even;
        even = myPow(5,even);
        odd = myPow(4,odd);
        return (int)((even*odd)%MOD);
    }
}

// Time complexity : O(log n)
// Space complexity : O(1)
