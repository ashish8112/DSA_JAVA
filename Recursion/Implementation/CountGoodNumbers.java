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

    
/*
Pattern: Binary Exponentiation with Mod (Fast Power)

Trigger: Power nikalni hai jahan exponent bahut bada hai (10^9, 10^15)
         aur answer "mod 1e9+7" maanga hai.

Template:
    long modPow(long base, long exp, long MOD) {
        if (exp == 0) return 1;
        if (exp % 2 == 0)
            return modPow((base*base) % MOD, exp/2, MOD);
        return (base * modPow((base*base) % MOD, exp/2, MOD)) % MOD;
    }

Key Insights:
1) Exponent har step pe aadha -> log n steps. Loop se n steps = TLE.
2) % MOD har multiply ke SAATH lagao, end me nahi.
   Math.pow pehle hi Infinity/garbage de deta hai, baad ka mod bekaar.
3) Dono operands < MOD (~10^9) -> product ~10^18 -> long me fit.
   Isliye long hi chahiye, aur har step pe mod zaroori.
4) Odd exponent pe ek base alag nikaalna mat bhoolo.
   Even/odd line same likh di to n=4 jaise cases pass ho jaate hain,
   bug chhup jaata hai.
5) Count Good Numbers: even positions (n+1)/2 pe 5 choices,
   odd n/2 pe 4 choices. Answer = 5^even * 4^odd mod.
6) Cast se PEHLE mod: (int)((a*b) % MOD), (int)(a*b) % MOD nahi.

Complexity: Time O(log n), Space O(log n) recursion
*/
