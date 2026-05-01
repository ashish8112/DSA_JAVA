class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int count =0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                count++;
                if(count>=2)
                res.append("(");
            }
            else{
                count--;
                if(count>=1)
                res.append(")");
            }
        }
        return res.toString();
    }
}
