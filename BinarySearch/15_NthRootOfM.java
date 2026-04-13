class Solution {
    public int nthRoot(int n, int m) {
        if(m==0)
        return 0;
        int low =1;
        int high =m;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int i=1;
            long p=1;
            while(i<=n)
            {
                p=p*mid;
                if(p>m)
                break;
                i++;
            }
            if(p==m)
            return  mid;
            else if(p>m)
            high=mid-1;
            else
            low=mid+1;
        }
        return -1;
    }
}

/*Pattern: Binary Search — Nth Root
Trigger: "nth root", "find x where x^n == m"
Template:
  long p = 1;
  for(int i=1;i<=n;i++) {
      p = p * mid;
      if(p > m) break; // early exit
  }
  if(p==m) return mid;
  else if(p>m) high=mid-1;
  else low=mid+1;
Key Insights:
  - mid^n calculate karo — long use karo overflow ke liye
  - p>m hote hi break — aage multiply karna wasteful
  - Answer nahi mila → return -1 (perfect root exist nahi)
Complexity: Time O(n * log m), Space O(1)*/
