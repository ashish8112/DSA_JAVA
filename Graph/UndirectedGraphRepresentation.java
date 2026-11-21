import java.util.*;
// Ignore all cosmetic print after taking inputs because they are used to show 
// relation between vertices with index number 

        // Adjacency matrix for undirected Graph
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices which n ");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges which m ");
        int m = sc.nextInt();
        int [][]mat = new int [n+1][n+1];
        for(int i=0;i<m;i++) // Adjacency Matrix 
            {
                System.out.println("Enter the start vertice number for edge");
                int start = sc.nextInt();
                System.out.println("Enter the end vertice number for edge");
                int end = sc.nextInt();
                mat[start][end]=1;
                mat[end][start]=1;
            }
        System.out.print(" ");
        for(int i=0;i<mat.length;i++)
            System.out.print(" "+i);
        System.out.println();
        for(int i=0;i<mat.length;i++)
            {
                System.out.print(i);
                for(int j=0;j<mat[i].length;j++)
                    System.out.print(" "+mat[i][j]);
                System.out.println();
            }
        
    }
}
        
// Time complexity : O(n*n)  matrix allocate + print. Edges daalna sirf O(m)
// Space complexity : O(n*n) edges kam hon tab bhi poori n x n matrix

  // Note : for weighted graph just change 1 with their weight of edges.


                        // Now using Adjacency List using Linked List
// In adjacency list we have to add every connected vertices with index vertices 
// like 
1,3 1,2 
2,3
so -> 1 - [2,3] 
      2 - [1,3]
      3 - [1,2] 
import java.util.*;
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices which n ");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges which m ");
        int m = sc.nextInt();
        LinkedList <Integer> [] arr = new LinkedList [n+1];
        for(int i=0;i<arr.length;i++)
            arr[i]=new LinkedList<>();
        for(int i=0;i<m;i++) // Adjacency List
            {
                System.out.println("Enter the start vertice number for edge");
                int start = sc.nextInt();
                System.out.println("Enter the end vertice number for edge");
                int end = sc.nextInt();
                arr[start].addLast(end);
                arr[end].addLast(start);
            }
        for(int i=0;i<arr.length;i++) // or skip i=0 start with i = 1
            {
                    System.out.println(i+" -> "+arr[i]);
            }
    }
}

// Time complexity : O(n+m) , n lists banana + m edges add karna and print (n+m) 
// Space complexiy : O(n+2m) // n for size of array which are vertices and 2m for linked lists why 2m because edge between 1 and 2 will come two, one time 
// for vertex 1 and another time for vertex 2 
// Note directed Graph mein O(n+m) kyuki ek hi tarf add honta hain 


                Space      Edge check u-v   Neighbours loop
Matrix          O(n^2)     O(1)             O(n)
Adj List        O(n+m)     O(deg)           O(deg)

Matrix:   n chhota (<= ~1000) ya baar-baar "u-v jude hain?" poochhna ho
Adj List: baaki sab jagah (LeetCode / interview default)

Directed:  sirf ek taraf add -> mat[u][v] = 1 / adj.get(u).add(v)
Weighted:  1 ki jagah weight
0-indexed: size n, n+1 nahi

        // as we know we have to store all connected vertices with each vertices so we can use ArrayList instead of linkedlist both are correct
        ex > 1 - [2,3] 
             2 - [1,3]
             3 - [1,2] 
                
import java.util.*;
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices which n ");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges which m ");
        int m = sc.nextInt();
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<=n;i++)
            list.add(new ArrayList<>());
        for(int i=0;i<m;i++) // Adjacency List
            {
                System.out.println("Enter the start vertice number for edge");
                int start = sc.nextInt();
                System.out.println("Enter the end vertice number for edge");
                int end = sc.nextInt();
                list.get(start).add(end);
                list.get(end).add(start);
              }
        for(int i=1;i<list.size();i++) // we can skip 0 as vertices are start from 1 
            {
                    System.out.println(i+" -> "+list.get(i));
            }
    }
}


// Time complexity : O(n+m) , n lists banana + m edges add karna and print (n+m) 
// Space complexiy : O(n+2m) // n for size of array which are vertices and 2m for linked lists why 2m because edge between 1 and 2 will come two, one time 
// for vertex 1 and another time for vertex 2 
// Note directed Graph mein O(n+m) kyuki ek hi tarf add honta hain 


                Space      Edge check u-v   Neighbours loop
Matrix          O(n^2)     O(1)             O(n)         // arr[u][v] ==1 this is edge check in matrix 
Adj List        O(n+m)     O(deg)           O(deg)       // we need check every element in inner list either it exist or not
        (deg = us vertex ke neighbours ki ginti)

Matrix:   n chhota (<= ~1000) ya baar-baar "u-v jude hain?" poochhna ho
Adj List: baaki sab jagah (LeetCode / interview default)

Directed:  sirf ek taraf add -> mat[u][v] = 1 / adj.get(u).add(v)
Weighted:  1 ki jagah weight
0-indexed: size n, n+1 nahi
