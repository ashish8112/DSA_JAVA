class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<strs.size();i++)
        {
            int count = strs.get(i).length();
            str.append(count);
            str.append("#");
            str.append(strs.get(i));
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        List <String>decoded = new ArrayList<>();
        while(i<str.length())
        {
            int pos = str.indexOf("#",i);
            int count = Integer.parseInt(str.substring(i, pos));
            decoded.add(str.substring(pos+1,pos+1+count));
            i=pos+1+count;
        }
        return decoded;
    }
}
