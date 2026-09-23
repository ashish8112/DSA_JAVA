class Solution {
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

