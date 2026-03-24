import java.util.*;

class SubstringWithKDistinct {
    public static int countSubstr(String s, int k) {
        int countSubstr=0;
        
        for(int i=0;i<s.length();i++)
        {
            int count =0;
            int [] freq = new int [128];
            for(int j=i;j<s.length();j++)
            {
               if(freq[s.charAt(j)]==0)//It checks either occurence of current element is first time or not 
               {
               count++;
               freq[s.charAt(j)]=1;//it updates the value of current element so next time it comes it  doesn't count as distinct.
               }
               if(count ==k)
               countSubstr++;
               else if(count>k)
               break;
            }
        }
        return countSubstr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = sc.next();
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();

        System.out.println("Number of substrings with exactly " + k + " distinct characters: " + countSubstr(s, k));
    }
}
