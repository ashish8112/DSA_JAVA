class BetterSolution {
    public void generate(StringBuilder str,List<String>list,int n)
    {
     if(str.length()==n*2)
     {
        boolean check = isValid(str.toString());
        if(check)
        list.add(str.toString());
        return;
     }
     str.append('(');
     generate(str,list,n);
     str.deleteCharAt(str.length()-1);
     str.append(')');
     generate(str,list,n);
     str.deleteCharAt(str.length()-1);
    }
    public boolean isValid(String s) {
       Stack <Character>stack = new Stack<>();
       for(int i=0;i<s.length();i++)
       {
         char ch = s.charAt(i);
         if(ch=='(')
         stack.push(ch);
         else{
            if(!stack.isEmpty() && stack.pop() == '(')
            continue;
            return false;
         }
       }
       if(!stack.isEmpty())
       return false;
       return true;
    }
    public List<String> generateParenthesis(int n) {
        List<String>list = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        generate(res,list,n);
        return list;
    }
}

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
