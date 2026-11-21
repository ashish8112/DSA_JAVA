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
// Time complexity : O(n*n)
// Space complexity : O(n*n)

  // Note : for weighted graph just change 1 with their weight of edges.

}
