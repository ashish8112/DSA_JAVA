class BruteSolution {
    public void generate(int n , List<String>list , StringBuilder res)
    {
        if(res.length()==n*2)
        {
            if(isValid(res))
            list.add(res.toString());
            return;
        }
        generate(n,list,res.append('('));
        res.deleteCharAt(res.length()-1);
        generate(n,list,res.append(')'));
        res.deleteCharAt(res.length()-1);
    }
    boolean isValid(StringBuilder res)
    {
        int count = 0;
        for(int i=0;i<res.length();i++)
        {
            if(res.charAt(i)=='(')
            count++;
            else count--;
            if(count<0)
            return false;
        }
        return count == 0;
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        generate(n,list,res);
        return list;
    }
}

//Time complexity = O(4^n*n) , as we know total no of nodes in perfect binary tree is 2 ^(h+1) - 1 suppose root at height 0 so 2^(0+1) -1 = 1 nodes 
// that's how here length = n we will repeat function until 2*n length of string so height of empty string will be 2n so => 2^(2n+1) - 1 and 2n for checking valid paraenthesis
// => 2^(2n) * 2n =>  4^n * n => O(n*4^n);
//space complexity = o(2n) height of recursion tree = > O(n) 

class BetterSolution {
    void generate(List<String>list,int n ,int i,int j,String str)
    {
        if(i+j==n*2)
        {
            list.add(str);
            return;
        }
        if(i<n)
        generate(list,n,i+1,j,str+"(");

        if(j<i)
        generate(list,n,i,j+1,str+")");
    }
    public List<String> generateParenthesis(int n) {
        List<String> paraenthesis = new ArrayList<>();
        generate(paraenthesis,n,0,0,"");
        return paraenthesis;
    }
}

// Time complexity = O(4^n) onnly *n removed because of checking valid paraenthesis
// Space complexiry = same  = O(n);

class OptimalSolution {
    void generate(List<String>list,int n ,int i,int j,StringBuilder str)
    {
        if(i+j==n*2)
        {
            list.add(str.toString());
            return;
        }
        if(i<n)
        {
            str.append('(');
            generate(list,n,i+1,j,str);
            str.deleteCharAt(str.length()-1);
        }
        
        if(j<i)
        {
            str.append(')');
            generate(list,n,i,j+1,str);
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> paraenthesis = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        generate(paraenthesis,n,0,0,str);
        return paraenthesis;
    }
}
// Time complexity = O(4^n) onnly *n removed because of checking valid paraenthesis
// Space complexiry = same  = O(n);



/*
Pattern: Generate & Filter vs Constrained Backtracking

Trigger: "Saare valid combinations banao" - jahan har position pe choices hain
         aur ek validity rule follow karna hai.

Brute:  poora tree banao (sab combinations), phir isValid() se check karo.
        O(4^n * n) - filtering ka cost bhi lagta hai.

Better: String concatenation (+) se sirf VALID paths banao.
        i < n aur j < i guards - invalid string kabhi bani hi nahi.
        O(4^n) - filter hata, par har level pe O(n) copy hoti hai (+ operator).

Optimal: StringBuilder + explicit backtrack (append -> recurse -> deleteCharAt).
        Same guards, par O(1) amortized per operation - koi copy nahi.

Key Insights:
1) i = open brackets used, j = close brackets used.
   i < n  -> '(' daal sakte ho (abhi bhi available hain)
   j < i  -> ')' daal sakte ho (balance kabhi negative nahi hoga)
2) Guards hi validity ka kaam karte hain - isValid() ki zaroorat hi
   khatam ho jaati hai jab sirf valid paths banao.
3) String + har level pe naya object banata hai (immutable) - safe hai
   har branch independent copy leke chalti hai, par O(n) copy cost.
   StringBuilder + deleteCharAt same effect deta hai bina copy ke,
   par append aur deleteCharAt ka pairing EXACT hona chahiye -
   jo add kiya wahi turant delete karo, usi block ke andar.
4) Choose -> recurse -> unchoose - yahi backtracking ka core shape hai.
   Subsets, Permutations, Combination Sum, N-Queens sab isi pe khade hain.

Complexity: Brute    - Time O(n * 4^n), Space O(n)
            Better   - Time O(4^n), Space O(n)
            Optimal  - Time O(4^n), Space O(n) - constant factor sabse chhota
*/
