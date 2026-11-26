class SolutionBFS {
    public void bfs(char[][] grid, int row, int col, boolean[][] vis) {
        vis[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { row, col });
        while (!q.isEmpty()) {
            row = q.peek()[0];
            col = q.peek()[1];
            q.poll();
            int[] deltaRow = { -1, 0, 1, 0 }; // top,right,bottom,left
            int[] deltaCol = { 0, 1, 0, -1 }; // top,right,bottom,left
            for (int i = 0; i < deltaRow.length; i++) {
                int neighborRow = row + deltaRow[i];
                int neighborCol = col + deltaCol[i];
                if ((neighborRow >= 0 && neighborRow < grid.length)
                        && (neighborCol >= 0 && neighborCol < grid[0].length)
                        && (grid[neighborRow][neighborCol] == '1' && !vis[neighborRow][neighborCol])) {
                    vis[neighborRow][neighborCol] = true;
                    q.offer(new int[] { neighborRow, neighborCol });
                }
            }

        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    bfs(grid, i, j, vis);
                }
            }
        }
        return count;
    }
}
