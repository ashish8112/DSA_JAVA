import java.util.*;
class PascalTriangle{
   public static List<List<Integer>> generate(int numRows) {//Without Math Operation 
        List <List <Integer>> list = new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            list.add(new ArrayList<>());
            int k=0;
            for(int j=0;j<i+1;j++)
            {
                if(j==0||j==i)
                list.get(i).add(1);
                else
                {
                    list.get(i).add(list.get(i-1).get(k++)+list.get(i-1).get(k)); // instead of k we can use j-1 and j 
                }
            }
        }
        return list;
    }
   public static List<List<Integer>> generateMath(int numRows) {//Using NcR formula.
        List <List <Integer>> list = new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
          List <Integer> temp = new ArrayList<>();
          int value=1;
          temp.add(value);
          for(int j=1;j<=i;j++)
          {
            value = value*(i-(j-1));
            value=value/j;
            temp.add(value);
          }
          list.add(temp);
        }
        return list;
    }
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row ");
        int row = sc.nextInt();
        List <List <Integer>> list = new ArrayList<>();
        list=generate(row);
        System.out.println(list);
    }
}
