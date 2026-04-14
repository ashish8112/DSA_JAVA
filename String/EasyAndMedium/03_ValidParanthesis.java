class Solution {
    public boolean isValid(String s) {
        char [] stack = new char [s.length()];
        int top = -1;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
            stack[++top]=s.charAt(i);
            else if (s.charAt(i)==')')
            {
                if(top>=0&&stack[top]=='(')
                top--;
                else 
                return false;
            }
            else if(s.charAt(i)=='}')
            {
                if(top>=0&&stack[top]=='{')
                top--;
                else return false;
            }
            else if(s.charAt(i)==']')
            {
                if(top>=0&&stack[top]=='[')
                top--;
                else return false;
            }
        }
        if(top!=-1)
        return false;
        return true;
    }
}
