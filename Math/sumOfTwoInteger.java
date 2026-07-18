class Solution {
    public int getSum(int a, int b) {
       while(b!=0)
        {
            int xorsum = a^b;
             b = (a&b)<<1;
            a=xorsum;
        }
        return a;
    }
}